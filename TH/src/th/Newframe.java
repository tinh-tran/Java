import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import jxl.Cell;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Newframe extends JFrame{
 
     Vector headers = new Vector();
     DefaultTableModel model = null;
     Vector data = new Vector();
     int tableWidth = 0;
     int tableHeight = 0; 
     
    public static void main(String[] args){
        Newframe frameTabel = new Newframe();
        
    }
    
    JTable table = new JTable();
    JScrollPane scroll = new JScrollPane(table); 
    JMenuBar mainmenu= new JMenuBar();
    JMenu File= new JMenu("File");
    JMenu edit= new JMenu("Edit");
    JMenu Open= new JMenu("Open");
    JMenuItem Chose= new JMenuItem("Choose");
    JMenuItem logout= new JMenuItem("Đăng Xuất");
    JMenuItem action1 = new JMenuItem("Bài Tập 1");
    JMenuItem action2 = new JMenuItem("Bài Tập 2");    
    JPanel panel = new JPanel();
    JFileChooser chooser= new JFileChooser();
    JButton click= new JButton("Chọn Tệp Excel File");
    

    Newframe(){
       super("Welcome!");
       setSize(600, 600);
       setResizable(true);
       setVisible(true);
       panel.setLayout(null);
       
       
        DefaultTableModel model = new DefaultTableModel(500,500);
        table.setModel(model);
        table.setAutoCreateRowSorter(true);
        model = new DefaultTableModel(500, 500);
        table.setModel(model);
        
        File.add(Open);
        File.add(Chose);
        File.add(logout);
        
        Open.add(action1);
        Open.add(action2);
        

        mainmenu.add(File);
        mainmenu.add(edit);
        
        
        panel.add(click);

        table.setAutoCreateRowSorter(true);
        table.setModel(model);
        tableWidth = model.getColumnCount() * 150;
        tableHeight = model.getRowCount() * 25;
        table.setPreferredSize(new Dimension(
        tableWidth, tableHeight));
        model = new DefaultTableModel(data, headers);
        
        scroll.setBackground(Color.pink);
        scroll.setPreferredSize(new Dimension(300, 300));
        scroll.setHorizontalScrollBarPolicy(
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        getContentPane().add(panel, 
              BorderLayout.NORTH);
        getContentPane().add(scroll, 
              BorderLayout.CENTER);
        
        
        setJMenuBar(mainmenu);
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        actionlogout();
        choose();
    }
    public void choose(){
        Chose.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent arg0) {
            chooser.showOpenDialog(null);

            File file = chooser.getSelectedFile();
            if (!file.getName().endsWith("xls")) {
                JOptionPane.showMessageDialog(null,
                        "Xin Vui Lòng Nhập File đúng định dạng.",
                        "Thông Báo", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                fillData(file);
                model = new DefaultTableModel(data, 
                  headers);
                tableWidth = model.getColumnCount() 
                  * 150;
                tableHeight = model.getRowCount() 
                  * 25;
                table.setPreferredSize(new Dimension(
                  tableWidth, tableHeight));

                table.setModel(model);
            }
        }
    });
    }
    public void actionlogout(){
        logout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){              
                    login regFace = new login();
                    regFace.setVisible(true);
                    dispose();
                }
        });
    }
    void fillData(File file) {
                Workbook workbook = null;
                try {
                 try {
                  workbook = Workbook.getWorkbook(file);
                 } catch (IOException ex) {
                  Logger.getLogger(
                    Newframe.class.
                    getName()).log(Level.SEVERE, 
                      null, ex);
                 }
                 Sheet sheet = workbook.getSheet(0);

                 headers.clear();
                 for (int i = 0; i < sheet.getColumns(); i++) {
                  Cell cell1 = sheet.getCell(i, 0);
                  headers.add(cell1.getContents());
                 }

                 data.clear();
                 for (int j = 1; j < sheet.getRows(); j++) {
                 Vector d = new Vector();
                    for (int i = 0; i < sheet.getColumns(); i++) {

                   Cell cell = sheet.getCell(i, j);

                   d.add(cell.getContents());

                  }
                  d.add("\n");
                  data.add(d);
                 }
                } catch (BiffException e) {
                 e.printStackTrace();
                }
               }
}