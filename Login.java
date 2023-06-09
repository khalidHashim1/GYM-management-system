/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adv_project1;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author K
 */
public class Login extends JFrame{
    // goes to the next frame. 
    static Login f = new Login(); 
    static String [] s; 
    // DB connection. 
    Connection con; 
    Statement st; 
    ResultSet rs; 
    // panel 
    private JPanel p1 = new JPanel(); 
    private JPanel p2 = new JPanel(); 
    // Icon 
    private Icon pic = new ImageIcon(getClass().getResource("gym4_1.png")); 
    // label normal 
    private JLabel l2 = new JLabel("Enter Username: "); 
    private JLabel l3 = new JLabel("Enter password: "); 
    // label for picture
    private JLabel l1 = new JLabel(pic); 
    // text felid 
    private JTextField t1 = new JTextField(20); 
    // password felid
    private JPasswordField pass = new JPasswordField("1010"); // temp.
    // button. 
    private JButton b1 = new JButton("Login"); 
    private JButton b2 = new JButton("Cancel"); 
    // Radio button. 
    private JRadioButton r1=new JRadioButton("Show password ");
    private JRadioButton r2=new JRadioButton("Hide password ");
    // Button Group 
    private ButtonGroup bg = new ButtonGroup(); 
    
    public Login() {
        setLayout(null);
        t1.setText("admin"); // temp.
        // Panel
        p1.setBackground(Color.DARK_GRAY);
        p1.setBounds(0, 0, 500, 515);
        p1.setLayout(null);
        p2.setLayout(null);
        p2.setBackground(Color.ORANGE);
        p2.setBounds(0, 0, 140, 515);
        // Adding panel to Jframe & panel to panel. 
        add(p1); p1.add(p2); 
        
        // Setting label with picture
        l1.setBounds(150, 0, 200, 150);
        
        // Setting Text felid 
        t1.setBounds(150, 250, 200, 20);
        // Setting password felid 
        pass.setBounds(150, 300, 200, 20);
        
        // Setting labels. 
        l2.setFont(new Font("Serif", Font.BOLD, 14));
        l3.setFont(new Font("Serif", Font.BOLD, 14));
        l2.setBounds(25, 250, 125, 20);
        l3.setBounds(25, 300, 125, 20);
        
        // Setting buttons. 
        b1.setBackground(Color.orange);
        b2.setBackground(Color.orange);
        b1.setBounds(150, 380, 80, 30);
        b2.setBounds(250, 380, 80, 30);
        
        // Setting Radio buttons. 
        r1.setBounds(150, 340, 120, 20);
        r2.setBounds(300, 340, 120, 20);
        
        // Button Grouping BG 
        bg.add(r1); bg.add(r2); 
        
        // Adding elements to panel 
        p1.add(l1); p1.add(t1); p1.add(pass); 
        p2.add(l2); p2.add(l3); 
        p1.add(b1); p1.add(b2); 
        p1.add(r1);p1.add(r2);
        
        // Actions. 
        myActions hand = new myActions(); 
        b1.addActionListener(hand);
        b2.addActionListener(hand);
        r1.addActionListener(hand);
        r2.addActionListener(hand);
        
    }
    
    private class myActions implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b1){
                // Adding Connection to DB here and check 
                connection();
                try { // Needs To check cursur to go to all data of login before making decision of not Entering DB. 
                    rs = st.executeQuery("Select * From LGTABLE where USERNAME = '"+t1.getText()+"'");
                    rs.next();
                    String username = rs.getString("username"); 
                    String userpass = rs.getString("password"); 
                    if(t1.getText().equals(username)&&pass.getText().equals(userpass)){
                        JOptionPane.showMessageDialog(null, "Successful");
                        f.dispose();
                        Dashbord frame3 = new Dashbord(); 
                        frame3.setVisible(true);
                        frame3.setSize(1600, 1000);
                        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame3.setResizable(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Username or Password Not correct try again!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                
            }
            if(e.getSource() == b2){
                System.exit(0);
            }
            if(e.getSource() == r1){
                pass.setEchoChar((char)0);
            }
            if(e.getSource() == r2){
                pass.setEchoChar('*');
            }
        }
    }
    
    private void connection(){
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Project1DB", "khalid", "1010"); 
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY); 
            rs = st.executeQuery("SELECT * FROM LGTABLE"); 
            rs.next();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void main(String[] args) {
        f.setSize(500, 550);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true); 
        f.setLocation(new Point(500, 500));
        f.setResizable(false);
    }
}
