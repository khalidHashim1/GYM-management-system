/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adv_project1;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author K
 */
public class Dashbord extends JFrame{
    // Project icon. 
    Icon pic = new ImageIcon(getClass().getResource("gym4_1.png")); 
    JLabel imageLabel1 = new JLabel(pic);
    // Copyright label
    JLabel copyright = new JLabel("Copyright \u00a9 2023 Khalid  Yasser  Omar  Fasial"); 
    // Panels. 
    JPanel p1 = new JPanel(); // left frame 
    JPanel p2 = new JPanel(); // the rest of the frame. 
    JPanel p2second = new JPanel(); // for the second frame. or panel 
    JPanel p3 = new JPanel(); // Add new panel to the frame. (in middle) for elements. 
    JPanel p3second = new JPanel(); // Add new panel to the frame. (in middle) for elements. 
    JPanel panTable = new JPanel(); 
    JPanel payPanel = new JPanel();
    // labels. 
    JLabel l1 = new JLabel("Member Name:"); 
    JLabel l2 = new JLabel("Phone Number:"); 
    JLabel l3 = new JLabel("Age:"); 
    JLabel l4 = new JLabel("Amount:"); 
    JLabel l5 = new JLabel("Timing:"); 
    JLabel l6 = new JLabel("Coach:"); 
    JLabel l7 = new JLabel("Gender:"); 
    JLabel l8 = new JLabel("Member List"); 
    JLabel l9 = new JLabel("Manage Members"); 
    JLabel l10 = new JLabel("Member ID:"); 
    
    // Payment labels. 
    JLabel pl1 = new JLabel("Month"); 
    JLabel pl2 = new JLabel("Member"); 
    JLabel pl3 = new JLabel("Amount"); 
    JLabel pl4 = new JLabel("Payments"); 
    JLabel pl5 = new JLabel("Manage Finance"); 
    // coach labels. 
    JLabel cl1 = new JLabel("Coach Name:");
    JLabel cl2 = new JLabel("Phone Number:"); 
    JLabel cl3 = new JLabel("Age:"); 
    JLabel cl4 = new JLabel("Address:"); 
    JLabel cl5 = new JLabel("Gender:"); 
    JLabel cl6 = new JLabel("Manage Coachs"); 
    JLabel cl7 = new JLabel("Coach ID:"); 
    // for panel1. 
    JLabel label1 = new JLabel("Coachs"); 
    JLabel label2 = new JLabel("Payment"); 
    JLabel label3 = new JLabel("Logout"); 
    
    // text felid
    JTextField t1 = new JTextField(20); 
    JTextField t2 = new JTextField(20); 
    JTextField t3 = new JTextField(20); 
    JTextField t4 = new JTextField(20); 
    JTextField t5 = new JTextField(20); 
    // Payment text felid. 
    JTextField pt1 = new JTextField(20); 
    JTextField pt2 = new JTextField(20); 
    JTextField pt3 = new JTextField(20); 
    JTextField pt4 = new JTextField(20); 
    // coach text felid. 
    JTextField ct1 = new JTextField(20); 
    JTextField ct2 = new JTextField(20); 
    JTextField ct3 = new JTextField(20); 
    JTextField ct4 = new JTextField(20); 
    JTextField ct5 = new JTextField(20); 
    // items of combo box. 
    String item1 [] = {"6pm-8pm", "8am-6am"};
    ArrayList<String> item2CoachesNames = new ArrayList<>();  
    ArrayList<String> item2MembersNames = new ArrayList<>(); 
    String item2 []; 
    String item3 [] = {"Male", "Female"};
    // Payment item combo box. 
    String pitem1[];
    // coach item combo box. 
    String citem1 [] = {"Male", "Female"};
    // combo box. 
    DefaultComboBoxModel<String> model; // Related to comboBox.
    JComboBox box1 = new JComboBox(item1);
    JComboBox<String> box2; // Intilize down.
    JComboBox box3 = new JComboBox(item3);
    // Payment combo box. 
    DefaultComboBoxModel<String> pmodel; // Related to comboBox.
    JComboBox<String> pbox1;// Intilize down.
    // combo box of coach 
    JComboBox cbox1 = new JComboBox(citem1);
    // Coach Table. temp 
    DefaultTableModel deftablemodelCoach = new DefaultTableModel(); 
    // Member Table. temp 
    DefaultTableModel deftablemodelMember = new DefaultTableModel(); 
    // Payment Table. tmep
    DefaultTableModel deftablemodelPayment = new DefaultTableModel(); 
    // Table. 
    JTable table = new JTable(deftablemodelMember); 
    JTable ctable = new JTable(deftablemodelCoach); 
    JTable ptable = new JTable(deftablemodelPayment); 
    
    // buttons. 
    JButton b1 = new JButton("Add"); 
    JButton b2 = new JButton("Edit"); 
    JButton b3 = new JButton("Delete"); 
    // buttons. 
    JButton cb1 = new JButton("Add"); 
    JButton cb2 = new JButton("Edit"); 
    JButton cb3 = new JButton("Delete");
    // Payment buttons. 
    JButton pb1 = new JButton("Pay"); 
    JButton pb2 = new JButton("Reset"); 
    JButton pb3 = new JButton("Search"); 
    JButton pb4 = new JButton("Refresh"); 
    JButton pb5 = new JButton("Print"); 
    // DB connections. 
    Connection con; 
    Statement st; 
    ResultSet rs; 
    String url = "jdbc:derby://localhost:1527/Project1DB", 
            user = "khalid", 
            pass ="1010"; 

    
    public Dashbord() {
        setLayout(null);
        connectStart();
        panel1();
        panel23M();
        
        // Actions. 
        myActions hand = new myActions(); 
        label1.addMouseListener(hand); 
        label2.addMouseListener(hand); 
        label3.addMouseListener(hand); 
        myButtonActions chand = new myButtonActions(); 
        cb1.addActionListener(chand); 
        b1.addActionListener(chand);
        pb1.addActionListener(chand);
        pb2.addActionListener(chand);
        pb4.addActionListener(chand);
        cb2.addActionListener(chand);
        cb3.addActionListener(chand);
        b2.addActionListener(chand);
        b3.addActionListener(chand);
        pb5.addActionListener(chand);
        pb3.addActionListener(chand);
    }
    private void panel1(){
        elementsPanel1();
        p1.setBounds(0, 0, 400, 1000);    // This can be Gridlayout. Not a good idea 
        // Adding elements on panel 1 
        p1.add(label1); p1.add(label2); p1.add(label3); 
        // panels. 
        p1.setLayout(null);
        p1.setBackground(Color.orange);
        p2.setBackground(Color.lightGray);
        add(p1); add(p2); add(p2second); add(payPanel); 
    }
    // DB connections. Coach & member. Only Works in first run 
    private final void connectStart(){
        try {
            con = DriverManager.getConnection(url, user, pass); 
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); 
            rs = st.executeQuery("SELECT * FROM KHALID.COACH"); 
            // Coach
            // Adding data to the table 
            deftablemodelCoach.setRowCount(10);
            deftablemodelCoach.addColumn("userId");
            deftablemodelCoach.addColumn("name");
            deftablemodelCoach.addColumn("Phone");
            deftablemodelCoach.addColumn("age");
            deftablemodelCoach.addColumn("address");
            deftablemodelCoach.addColumn("gender");
            while(rs.next()){
                int i=0; 
                String id = rs.getString(1); 
                String name = rs.getString(2); 
                String phone = rs.getString(3); 
                String age = String.valueOf(rs.getInt(4)); 
                String address = rs.getString(5); 
                String gender = rs.getString(6); 
                deftablemodelCoach.insertRow(i, new Object[]{id, name, phone, age, address, gender});
                i++; 
            }
            // Member 
            rs = st.executeQuery("SELECT * FROM KHALID.MEMBER"); 
            deftablemodelMember.setRowCount(10);
            deftablemodelMember.addColumn("userId");
            deftablemodelMember.addColumn("name");
            deftablemodelMember.addColumn("age");
            deftablemodelMember.addColumn("amount");
            deftablemodelMember.addColumn("time");
            deftablemodelMember.addColumn("Cname");
            deftablemodelMember.addColumn("gender");
            while(rs.next()){
                int i=0; 
                String mid = rs.getString(1); 
                String mname = rs.getString(2); 
                String mphone = rs.getString(3); 
                String mage = rs.getString(4); 
                String mamount = String.valueOf(rs.getDouble(5)); 
                String mtime = rs.getString(6); 
                String mCname = rs.getString(7); 
                String mgender = rs.getString(8); 
                deftablemodelMember.insertRow(i, new Object[]{mid, mname, mphone, mage, mamount, mtime, mCname, mgender});
                i++; 
            }
            // Payment 
            rs = st.executeQuery("SELECT * FROM KHALID.PAYMENT"); 
            deftablemodelPayment.setRowCount(10);
            deftablemodelPayment.addColumn("Pmid");
            deftablemodelPayment.addColumn("Pmname");
            deftablemodelPayment.addColumn("Pmamount");
            
            while(rs.next()){
                int i=0; 
                String Pmid = rs.getString(1); 
                String Pmname = rs.getString(2); 
                String Pmamount = rs.getString(3); 
                deftablemodelPayment.insertRow(i, new Object[]{Pmid, Pmname, Pmamount});
                i++; 
            }
            // Name of Coaches inserted into box in member panel. 
            gettingNamesOfCoaches();
            // Name of Members inserted into box in Payment panel. 
            gettingNamesOfMembersAndIDs();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private final void connectStartRefresh(){
        try {
            con = DriverManager.getConnection(url, user, pass); 
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); 
            rs = st.executeQuery("SELECT * FROM KHALID.COACH"); 
            // Coach
            // Adding data to the table 
            deftablemodelCoach.setRowCount(0);
            while(rs.next()){
                int i=0; 
                String id = rs.getString(1); 
                String name = rs.getString(2); 
                String phone = rs.getString(3); 
                String age = String.valueOf(rs.getInt(4)); 
                String address = rs.getString(5); 
                String gender = rs.getString(6); 
                deftablemodelCoach.insertRow(i, new Object[]{id, name, phone, age, address, gender});
                i++; 
            }
            // Member 
            rs = st.executeQuery("SELECT * FROM KHALID.MEMBER"); 
            deftablemodelMember.setRowCount(0);
            while(rs.next()){
                int i=0; 
                String mid = rs.getString(1); 
                String mname = rs.getString(2); 
                String mphone = rs.getString(3); 
                String mage = rs.getString(4); 
                String mamount = String.valueOf(rs.getDouble(5)); 
                String mtime = rs.getString(6); 
                String mCname = rs.getString(7); 
                String mgender = rs.getString(8); 
                deftablemodelMember.insertRow(i, new Object[]{mid, mname, mphone, mage, mamount, mtime, mCname, mgender});
                i++; 
            }
            // Payment 
            rs = st.executeQuery("SELECT * FROM KHALID.PAYMENT"); 
            
            deftablemodelPayment.setRowCount(0);
            while(rs.next()){
                int i=0; 
                String Pmid = rs.getString(1); 
                String Pmname = rs.getString(2); 
                String Pmamount = rs.getString(3); 
                deftablemodelPayment.insertRow(i, new Object[]{Pmid, Pmname, Pmamount});
                i++; 
            }
            // Name of Coaches inserted into box in member panel. 
            gettingNamesOfCoaches();
            // Name of Members inserted into box in Payment panel. 
            gettingNamesOfMembersAndIDs();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    private void gettingNamesOfCoaches(){ // in member panel. 
        try { 
            rs = st.executeQuery("SELECT cname, cid FROM COACH");
            item2CoachesNames.add("None"); 
            while(rs.next()){
                item2CoachesNames.add(rs.getString("cname")+" \\ "+rs.getString("cid")); 
            }
            item2 = new String[item2CoachesNames.size()]; 
            for(int i=0; i<item2.length; i++){
                item2[i] = item2CoachesNames.get(i); 
            }
            model = new DefaultComboBoxModel<>(item2);
            box2 = new JComboBox<>(model); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    private void addingNameCoach(String newName){
        model.addElement(newName);
        box2 = new JComboBox<>(model);
    }
    
    private void removingNameCoach(String newName){
        model.removeElement(newName);
        box2 = new JComboBox<>(model);
    }
    
    private void gettingNamesOfMembersAndIDs(){ // Payment box.
        try { 
            rs = st.executeQuery("SELECT mname, mid FROM Member");
            item2MembersNames.add("None"); 
            while(rs.next()){
                item2MembersNames.add(rs.getString("mname")+" \\ "+rs.getString("mid")); 
            }
            pitem1 = new String[item2MembersNames.size()]; 
            for(int i=0; i<pitem1.length; i++){
                pitem1[i] = item2MembersNames.get(i); 
            }
            pmodel = new DefaultComboBoxModel<>(pitem1);
            pbox1 = new JComboBox<>(pmodel); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }
    private void addingNameMember(String newName){
        pmodel.addElement(newName);
        pbox1 = new JComboBox<>(pmodel);
    }
    
    private final void CoachConnect(){
        try {
            con = DriverManager.getConnection(url, user, pass); 
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); 
            rs = st.executeQuery("SELECT * FROM COACH");
            rs.next(); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private final void MemberConnect(){
        try {
            con = DriverManager.getConnection(url, user, pass); 
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); 
            rs = st.executeQuery("SELECT * FROM MEMBER");
            rs.next(); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    // Coach Add DB. ----------------------------------
    private class myButtonActions implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == cb1){ // Adding button in coach panel
                try {
                    if(!ct1.getText().isEmpty() && !ct2.getText().isEmpty() && !ct3.getText().isEmpty()){
                        rs = st.executeQuery("SELECT * FROM KHALID.COACH"); 
                        rs.moveToInsertRow();// insert row 
                        rs.updateInt(1, Integer.parseInt(creatIDCoach()));
                        rs.updateString(2, ct1.getText());
                        rs.updateString(3, ct2.getText());
                        rs.updateString(4, ct3.getText());
                        rs.updateString(5, ct4.getText());
                        rs.updateString(6, cbox1.getSelectedItem().toString());
                        rs.insertRow();
                        deftablemodelCoach.insertRow(rs.getRow(), new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), String.valueOf(rs.getInt(4)), rs.getString(5),  rs.getString(6)});
                        addingNameCoach(ct1.getText()+" \\ "+creatIDCoach());
                        rs.close();
                        JOptionPane.showMessageDialog(null, "Added Done");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Enter Data Correct");
                        rs.close();
                    }
                    
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                CoachConnect();
            }
            if(e.getSource() == b1){ // Adding button in member panel. 
                try {
                    rs.moveToInsertRow();
                    if(!t1.getText().isEmpty() && !t2.getText().isEmpty() && !t3.getText().isEmpty() && !t4.getText().isEmpty()){
                        rs = st.executeQuery("SELECT * FROM KHALID.Member"); 
                        rs.moveToInsertRow();
                        rs.updateString(1, creatIDMember());
                        rs.updateString(2, t1.getText());
                        rs.updateString(3, t2.getText());
                        rs.updateString(4, t3.getText());
                        rs.updateString(5, t4.getText());
                        rs.updateString(6, box1.getSelectedItem().toString());
                        rs.updateString(7, box2.getSelectedItem().toString());
                        rs.updateString(8, box3.getSelectedItem().toString());
                        rs.insertRow();
                        deftablemodelMember.insertRow(rs.getRow(), new Object[]{rs.getString(1), rs.getString(2), rs.getString(3), String.valueOf(rs.getInt(4)), rs.getString(5),  rs.getString(6)
                                                    ,  rs.getString(7),  rs.getString(8)});
                        addingNameMember(t1.getText()+" \\ "+creatIDMember());
                        rs.close();
                        // Adding Amount in Payment DB. 
                        ResultSet res = st.executeQuery("Select * From Payment"); 
                        res.moveToInsertRow();
                        res.updateString(1, creatIDMember());
                        res.updateString(2, t1.getText());
                        res.updateString(3, t4.getText());
                        res.insertRow();
                        res.close();
                        JOptionPane.showMessageDialog(null, "Added Done");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Enter Data Correct");
                        rs.close();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                MemberConnect();
            }
            if(e.getSource() == pb1){ // Adding Pay (button) in payment panel. 
                if(!pt3.getText().isEmpty()){
                    try { 
                        ResultSet res = st.executeQuery("SELECT * FROM PAYMENT");
                        int i=0; 
                        while(res.next()){
                            if(splittingID(pbox1.getSelectedItem().toString()).equals(res.getString(1))){
                                res.moveToCurrentRow();
                                double num = Double.parseDouble(pt3.getText());
                                num += Double.parseDouble(res.getString(3));
                                res.updateString("pmamount", String.valueOf(num));
                                res.updateRow();
                                JOptionPane.showMessageDialog(null, "Payment is Done"); 
                                i = 1; 
                                break;
                            }
                        }
                        res.close();
                        connectStartRefresh();
                        if(i == 0)
                            JOptionPane.showMessageDialog(null, "User is not found");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Enter Amount please");
            }
            if(e.getSource() == pb2){ // Adding reset (button) in payment panel. 
                pt3.setText("");
            }
            if(e.getSource() == pb4){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                connectStartRefresh();
                gettingNamesOfMembersAndIDs();
            }
            if(e.getSource() == pb5){
                try { 
                    ptable.print();
                } catch (PrinterException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            if(e.getSource() == cb2){ // Update button works in Coach panel, But we need refresh (Button) to show the data in jtable. 
                if(!ct5.getText().isEmpty()){
                    if(!ct1.getText().isEmpty() && !ct2.getText().isEmpty() && !ct3.getText().isEmpty()){
                        try { 
                            ResultSet res = st.executeQuery("SELECT * FROM KHALID.COACH");
                            int i=0; 
                            while(res.next()){
                                if(res.getString(1).equals(ct5.getText())){
                                    res.updateString(2, ct1.getText());
                                    res.updateString(3, ct2.getText());
                                    res.updateString(4, ct3.getText());
                                    res.updateString(5, ct4.getText());
                                    res.updateString(6, cbox1.getSelectedItem().toString());
                                    res.updateRow();
                                    i=1; 
                                    JOptionPane.showMessageDialog(null, "Update Done");
                                    break; 
                                }
                            }
                            res.close();
                            connectStartRefresh();
                            if(i==0)
                                JOptionPane.showMessageDialog(null, "User not found");
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Fill the form with data.");
                }else
                    JOptionPane.showConfirmDialog(null, "enter ID for Updating data."); 
            }
            if(e.getSource() == cb3){ // Delete is also done But, also still have the refresh (button) problem in coach panel.
                if(!ct5.getText().isEmpty()){
                    try {
                        ResultSet res = st.executeQuery("SELECT * FROM COACH"); 
                        int i=0; 
                        while(res.next()){
                            if(res.getString(1).equals(ct5.getText())){
                                res.deleteRow();
                                //removingNameCoach(ct5.getText()+" \\ "+rs.getString(2));
                                JOptionPane.showMessageDialog(null, "Delete is done");
                                i=1; 
                                break; 
                            }
                        }
                        res.close();
                        connectStartRefresh();
                        if(i==0)
                            JOptionPane.showMessageDialog(null, "User not found");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }else
                    JOptionPane.showConfirmDialog(null, "enter ID for Deleting data."); 
            }
            if(e.getSource() == b2){ // Adding edit (button) in member panel. 
                if(!t5.getText().isEmpty()){
                    if(!t1.getText().isEmpty() && !t2.getText().isEmpty() && !t3.getText().isEmpty() && !t4.getText().isEmpty()){
                    try { 
                        ResultSet res = st.executeQuery("SELECT * FROM MEMBER");
                        int i=0; 
                        while(res.next()){
                            if(res.getString(1).equals(t5.getText())){
                                res.updateString(2, t1.getText());
                                res.updateString(3, t2.getText());
                                res.updateString(4, t3.getText());
                                res.updateString(5, t4.getText());
                                res.updateString(6, box1.getSelectedItem().toString());
                                res.updateString(7, box2.getSelectedItem().toString());
                                res.updateString(8, box3.getSelectedItem().toString());
                                res.updateRow();
                                JOptionPane.showMessageDialog(null, "Update is done"); 
                                i=1; 
                                break;
                            }
                        }
                        res.close();
                        connectStartRefresh();
                        if(i==0)
                            JOptionPane.showMessageDialog(null, "User not found");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                    }else
                        JOptionPane.showMessageDialog(null, "Fill the form with data.");
                }else 
                    JOptionPane.showMessageDialog(null, "enter ID:");
            }
            if(e.getSource() == b3){ // Adding delete (button) in member panel.
                if(!t5.getText().isEmpty()){
                    try { 
                        rs = st.executeQuery("SELECT * FROM MEMBER");
                        int i=0; 
                        while(rs.next()){
                            if(rs.getString(1).equals(t5.getText())){
                                rs.moveToCurrentRow();
                                rs.deleteRow();
                                JOptionPane.showMessageDialog(null, "Delete is done");
                                i=1; 
                                break; 
                            }
                        }
                        rs.close();
                        connectStartRefresh();
                        if(i==0)
                            JOptionPane.showMessageDialog(null, "User not found");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex);
                    }
                }
            }
            if(e.getSource() == pb3){
                try { 
                    rs = st.executeQuery("SELECT * FROM PAYMENT where PMAMOUNT like '"+pt4.getText()+"'");
                    rs.next();
                    deftablemodelPayment.setRowCount(0);
                    while(rs.next()){
                        String id = rs.getString(1); 
                        String name = rs.getString(2); 
                        String amount = rs.getString(3); 
                        deftablemodelPayment.insertRow(0, new Object[]{id, name, amount});
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }
    
    private String splittingID(String name){
        String res = ""; 
        for(int i=name.length()-1; i>=0; i--){
            if(name.charAt(i) != '\\')
                res += name.charAt(i); 
            else
                break;
        }
        return new StringBuilder(res).reverse().toString().trim(); 
    }
    
    private String creatIDCoach(){
        String id = "44"+ct2.getText().substring(6);
        return id; 
    }
    private String creatIDMember(){
        String id = "44"+t2.getText().substring(6);
        return id; 
    }
    
    private class  myActions implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == label1){
                    if(label1.getText().equals("Coachs")){
                        payPanel.show(false);
                        p2.show(false);
                        p2second.show(true);
                        label1.setText("Members");
                        coachPanel();
                    }else{
                        payPanel.show(false);
                        p2second.show(false);
                        p2.show(true);
                        label1.setText("Coachs");
                        panel23M();
                    }
            }
            if(e.getSource() == label2){
                payPanel.show(true);
                p2.show(false);
                p2second.show(false);
                paymentPanel3();
            }
            if(e.getSource() == label3)
                System.exit(0);
        }
        @Override
        public void mousePressed(MouseEvent e) {
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            if(e.getSource() == label1)
                label1.setForeground(Color.red);
            if(e.getSource() == label2)
                label2.setForeground(Color.red);
            if(e.getSource() == label3)
                label3.setForeground(Color.red);
        }
        @Override
        public void mouseExited(MouseEvent e) {
            if(e.getSource() == label1)
                label1.setForeground(Color.black);
            if(e.getSource() == label2)
                label2.setForeground(Color.black);
            if(e.getSource() == label3)
                label3.setForeground(Color.black);
        }
        
    } // main 
    public static void main(String[] args) {
        
        Dashbord f = new Dashbord(); 
        f.setVisible(true); 
        f.setSize(1600, 1000);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("GYM management system");
        f.setResizable(false);
        
    }
    // FRONT END --------------------------------------------------------------
    private void paymentPanel3(){
        // panel 
        payPanel.setBounds(400, 0, 1200, 1000);
        payPanel.setLayout(null);
        payPanel.setBackground(Color.DARK_GRAY);
        paymentEelements();
    }
    
    private void paymentEelements(){
        // logo 
        pl5.setBounds(525, 15, 300, 100);
        pl5.setForeground(Color.orange);
        pl5.setFont(new Font("Serif", Font.BOLD, 28));
        payPanel.add(pl5);
        // 1 
        pl1.setBounds(100, 150, 100, 100);
        pl1.setForeground(Color.orange);
        pl1.setFont(new Font("Serif", Font.BOLD, 22));
        pt1.setBounds(100, 250, 200, 40);
        //payPanel.add(pl1); payPanel.add(pt1); 
        // 2 
        pl2.setBounds(100, 150, 100, 100);
        pl2.setForeground(Color.orange);
        pl2.setFont(new Font("Serif", Font.BOLD, 22));
        pbox1.setBounds(100, 250, 200, 40);
        payPanel.add(pl2); payPanel.add(pbox1); 
        // 3 
        pl3.setBounds(100, 300, 100, 100);
        pl3.setForeground(Color.orange);
        pl3.setFont(new Font("Serif", Font.BOLD, 22));
        pt3.setBounds(100, 400, 200, 40);
        payPanel.add(pl3); payPanel.add(pt3); 
        // 4 
        pl4.setBounds(600, 100, 100, 100);
        pl4.setForeground(Color.orange);
        pl4.setFont(new Font("Serif", Font.BOLD, 22));
        pt4.setBounds(600, 175, 200, 30);
        payPanel.add(pl4); payPanel.add(pt4); 
        // buttons. Pay , Reset. 
        pb1.setBounds(100, 550, 100, 40);
        pb2.setBounds(210, 550, 100, 40);
        pb3.setBounds(850, 175, 100, 40);
        pb4.setBounds(1000, 175, 100, 40);
        pb5.setBounds(800, 800, 100, 40);
        // font
        pb1.setFont(new Font("Serif", Font.BOLD, 18));
        pb2.setFont(new Font("Serif", Font.BOLD, 18));
        pb3.setFont(new Font("Serif", Font.BOLD, 18));
        pb4.setFont(new Font("Serif", Font.BOLD, 18));
        pb5.setFont(new Font("Serif", Font.BOLD, 18));
        pb1.setBackground(Color.LIGHT_GRAY);
        pb2.setBackground(Color.LIGHT_GRAY);
        pb3.setBackground(Color.LIGHT_GRAY);
        pb4.setBackground(Color.LIGHT_GRAY);
        pb5.setBackground(Color.LIGHT_GRAY);
        pb1.setForeground(Color.BLACK);
        pb2.setForeground(Color.BLACK);
        pb3.setForeground(Color.BLACK);
        pb4.setForeground(Color.BLACK);
        pb5.setForeground(Color.BLACK);
        payPanel.add(pb1); payPanel.add(pb2); payPanel.add(pb3); payPanel.add(pb4); payPanel.add(pb5); 
        // Table. 
        ptable.setBounds(600, 250, 500, 500);
        payPanel.add(ptable); 
    }
    
    private void coachPanel(){
        // Table added to p2second. 
        ctable.setBounds(0, 550, 1200, 500);
        panTable.add(ctable); 
        // Adding elements 
        elementsCoachPanel();
        // panel3. 
        p3second.setBackground(Color.darkGray);
        p3second.setBounds(0, 0, 1200, 550);
        p3second.setLayout(null);
        // panel 2. 
        p2second.setBackground(Color.red);
        p2second.setBounds(400, 0, 1200, 1000); // This can be Gridlayout. Not a good idea 
        p2second.setLayout(null);
        p2second.add(ctable); // Adding panTable to p2. 
        p2second.add(p3second); // adding p3 to p2. 
    }
    private void elementsCoachPanel(){
        // logo 
        cl6.setBounds(525, 15, 300, 100);
        cl6.setForeground(Color.orange);
        cl6.setFont(new Font("Serif", Font.BOLD, 28));
        p3second.add(cl6);
        // ID section. 
        cl7.setBounds(100, 250, 300, 100);
        cl7.setForeground(Color.orange);
        cl7.setFont(new Font("Serif", Font.BOLD, 22));
        ct5.setBounds(100, 350, 200, 40);
        p3second.add(cl7); p3second.add(ct5); 
        // 1 
        cl1.setBounds(100, 100, 200, 100);
        cl1.setForeground(Color.orange);
        cl1.setFont(new Font("Serif", Font.BOLD, 22));
        ct1.setBounds(100, 200, 200, 40);
        p3second.add(cl1); p3second.add(ct1); 
        // 2 
        cl2.setBounds(400, 100, 200, 100);
        cl2.setForeground(Color.orange);
        cl2.setFont(new Font("Serif", Font.BOLD, 22));
        ct2.setBounds(400, 200, 200, 40);
        p3second.add(cl2); p3second.add(ct2); 
        // 3 
        cl3.setBounds(700, 100, 200, 100);
        cl3.setForeground(Color.orange);
        cl3.setFont(new Font("Serif", Font.BOLD, 22));
        ct3.setBounds(700, 200, 100, 40);
        p3second.add(cl3); p3second.add(ct3); 
        // 4 
        cl4.setBounds(900, 100, 200, 100);
        cl4.setForeground(Color.orange);
        cl4.setFont(new Font("Serif", Font.BOLD, 22));
        ct4.setBounds(900, 200, 200, 40);
        p3second.add(cl4); p3second.add(ct4); 
        // 5 
        cl5.setBounds(500, 250, 200, 100);
        cl5.setForeground(Color.orange);
        cl5.setFont(new Font("Serif", Font.BOLD, 22));
        cbox1.setBounds(500, 350, 100, 40);
        p3second.add(cl5); p3second.add(cbox1); 
        // buttons on coach 
        // buttons. 
        cb1.setBounds(300, 450, 100, 40);
        cb2.setBounds(550, 450, 100, 40);
        cb3.setBounds(800, 450, 100, 40);
        cb1.setFont(new Font("Serif", Font.BOLD, 18));
        cb2.setFont(new Font("Serif", Font.BOLD, 18));
        cb3.setFont(new Font("Serif", Font.BOLD, 18));
        cb1.setBackground(Color.lightGray);
        cb2.setBackground(Color.lightGray);
        cb3.setBackground(Color.lightGray);
        p3second.add(cb1); p3second.add(cb2); p3second.add(cb3); 
    }
    
    private void panel23M(){
        // panel table. 
        panTable.setBounds(0, 550, 1200, 1000);
        panTable.setBackground(Color.red);
        panTable.setLayout(null);
        table.setBounds(0, 0, 1200, 500);
        panTable.add(table); 
        // Elements BOUNDS.
        elemntsMembers();
        // Adding Elements
        p3.add(l9);
        p3.add(l1); p3.add(t1); p3.add(l2); p3.add(t2); p3.add(l3); p3.add(t3); p3.add(l4); p3.add(t4);
        p3.add(l5); p3.add(box1); p3.add(l6); p3.add(box2); p3.add(l7); p3.add(box3); 
        p3.add(b1); p3.add(b2); p3.add(b3); 
        // panels. 
        // panel3. 
        p3.setBackground(Color.darkGray);
        p3.setBounds(0, 0, 1200, 550);
        p3.setLayout(null);
        // panel 2. 
        p2.setBounds(400, 0, 1200, 1000); // This can be Gridlayout. Not a good idea 
        p2.setLayout(null);
        p2.add(panTable); // Adding panTable to p2. 
        p2.add(p3); // adding p3 to p2. 
        
    }
    
    private void elemntsMembers(){
        // logo 
        l9.setBounds(525, 15, 300, 100);    
        l9.setForeground(Color.orange);
        l9.setFont(new Font("Serif", Font.BOLD, 28));
        // Adding id panel. 
        l10.setBounds(100, 375, 200, 100);
        l10.setForeground(Color.orange);
        l10.setFont(new Font("Serif", Font.BOLD, 22));
        t5.setBounds(100, 450, 200, 40);
        p3.add(l10); p3.add(t5);
        // 1
        l1.setBounds(100, 100, 200, 100);
        l1.setForeground(Color.orange);
        l1.setFont(new Font("Serif", Font.BOLD, 22));
        t1.setBounds(100, 200, 200, 40);
        // 2 
        l2.setBounds(400, 100, 200, 100);
        l2.setForeground(Color.orange);
        l2.setFont(new Font("Serif", Font.BOLD, 22));
        t2.setBounds(400, 200, 200, 40);
        // 3 
        l3.setBounds(700, 100, 200, 100);
        l3.setForeground(Color.orange);
        l3.setFont(new Font("Serif", Font.BOLD, 22));
        t3.setBounds(700, 200, 100, 40);
        // 4 
        l4.setBounds(900, 100, 200, 100);
        l4.setForeground(Color.orange);
        l4.setFont(new Font("Serif", Font.BOLD, 22));
        t4.setBounds(900, 200, 200, 40);
        // 5 
        l5.setBounds(100, 250, 200, 100);
        l5.setForeground(Color.orange);
        l5.setFont(new Font("Serif", Font.BOLD, 22));
        box1.setBounds(100, 350, 200, 40);
        // 6 
        l6.setBounds(500, 250, 200, 100);
        l6.setForeground(Color.orange);
        l6.setFont(new Font("Serif", Font.BOLD, 22));
        box2.setBounds(500, 350, 200, 40);
        // 7 
        l7.setBounds(850, 250, 200, 100);
        l7.setForeground(Color.orange);
        l7.setFont(new Font("Serif", Font.BOLD, 22));
        box3.setBounds(850, 350, 200, 40);
        // buttons. 
        b1.setBounds(450, 450, 100, 40);
        b2.setBounds(700, 450, 100, 40);
        b3.setBounds(950, 450, 100, 40);
        b1.setFont(new Font("Serif", Font.BOLD, 18));
        b2.setFont(new Font("Serif", Font.BOLD, 18));
        b3.setFont(new Font("Serif", Font.BOLD, 18));
        b1.setBackground(Color.lightGray);
        b2.setBackground(Color.lightGray);
        b3.setBackground(Color.lightGray);
    }
    private void elementsPanel1(){
        // Elemnts on panel 1 
        label1.setBounds(150, 250, 150, 50);
        label1.setFont(new Font("Serif", Font.BOLD, 36));
        label2.setBounds(150, 400, 135, 50);
        label2.setFont(new Font("Serif", Font.BOLD, 36));
        label3.setBounds(150, 550, 115, 50);
        label3.setFont(new Font("Serif", Font.BOLD, 36));
        // Image 
        imageLabel1.setBounds(110, 2, 200, 200);
        p1.add(imageLabel1);
        // copyright label. 
        copyright.setBounds(50, 750, 325, 250);
        copyright.setFont(new Font("Arial", Font.BOLD, 15));
        p1.add(copyright);
    }
}
