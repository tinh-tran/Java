import javax.swing.*;
import javax.swing.AbstractAction;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

public class login extends JFrame{

    public static void main(String[] args) {
        login frameTabel = new login();
    }

    JButton blogin = new JButton("Đăng nhập");    
    JButton out = new JButton("Thoát");
    JMenuBar mainmenu= new JMenuBar();
    JMenuItem exit= new JMenuItem("Thoát");
    JPanel panel = new JPanel();
    JLabel username = new JLabel("Tên đăng nhập:");
    JLabel password = new JLabel("Mật khẩu:");
    JTextField txtadmin = new JTextField(15);
    JPasswordField pass = new JPasswordField(15);
    

    login(){
        super("Đăng nhập");
        setSize(400,300);
        setLocation(500,280);
        setResizable(false);
        panel.setLayout(null);

        username.setBounds(80, 65, 100, 20);
        password.setBounds(80, 110, 100, 20);
        txtadmin.setBounds(200, 65, 150, 20);
        pass.setBounds(200, 110, 150, 20);
        blogin.setBounds(160, 180, 100, 20);
        //out.setBounds(80, 180, 80, 20);

        //panel.add(out);
        panel.add(blogin);
        panel.add(username);
        panel.add(password);
        panel.add(txtadmin);
        panel.add(pass);
        
        mainmenu.add(exit);

        
        setJMenuBar(mainmenu);
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        actionlogin();
        actionExit();
        
       
    }
 public void actionlogin(){
        blogin.addActionListener(new ActionListener(){            
            public void actionPerformed(ActionEvent ae){
                String paname = txtadmin.getText();
                String ppaswd = pass.getText();
                if(paname.equals("admin") && ppaswd.equals("admin")){
                    Newframe regFace = new Newframe();
                    regFace.setVisible(true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Tên đăng nhập / "
                            + "Mật khẩu không đúng");
                    txtadmin.setText("");
                    pass.setText("");
                    txtadmin.requestFocus();
                    }
                }
        });
    }
 public void actionExit(){
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               System.exit(0); 
            }
        }
        );
}
}
