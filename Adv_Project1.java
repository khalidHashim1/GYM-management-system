/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adv_project1;
import javax.swing.*; 
import java.sql.*; 
import java.awt.*; 
/**
 *
 * @author K
 */
public class Adv_Project1 extends JFrame{
    // icon 
    private Icon pic = new ImageIcon(getClass().getResource("logo_1.jpg")); 
    // label 
    private JLabel l1 = new JLabel(pic); 
    // Progress bar. 
    static JProgressBar lodingBar = new JProgressBar(); 

    public Adv_Project1() {
        setLayout(null); 
        // label with image 
        l1.setBounds(0, 0, 500, 500);
        add(l1); 
        // progress bar. 
        lodingBar.setBounds(0, 500, 500, 10);
        add(lodingBar); 
        
    }
    
    public static void startingBar(){
        try {
            for(int i=0; i<=100; i++){
                Thread.sleep(20);
                lodingBar.setValue(i);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Adv_Project1 f = new Adv_Project1(); 
        f.setSize(500, 550);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true); 
        f.setLocation(new Point(500, 500));
        f.setResizable(false);
        // Starting the load      Note: Don't change anything in this folder. 
        startingBar();
        f.dispose();
        
        // Second freme 
        Login frame2 = new Login();
        frame2.main(args);
        
    }
    
}
