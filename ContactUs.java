/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterproject;

import javax.swing.JLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class ContactUs2 implements ActionListener {

    JFrame f;
    JLabel icon;
    JLabel contactus;
    JLabel welcome;
    JLabel name;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;
    JButton b1;
    JButton b2;
    JButton back;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;

    Connection con;

    ContactUs2() {

        f = new JFrame("Contact Us");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setSize(900, 650);
        f.setLocationRelativeTo(null);
        f.setResizable(false);
        f.getContentPane().setBackground(new Color(200, 0, 50));

        ImageIcon image = new ImageIcon("dude1.png");
        icon = new JLabel();
        icon.setBounds(80, 65, 252, 247);
        icon.setIcon(image);

        welcome = new JLabel(" INTERNATIONAL ");
        welcome.setBounds(40, 330, 400, 40);
        welcome.setForeground(Color.yellow);
        welcome.setFont(new Font("Sans Serif", Font.BOLD, 40));

        name = new JLabel(" AIRLINES ");
        name.setBounds(110, 400, 440, 40);
        name.setForeground(Color.yellow);
        name.setFont(new Font("Sans Serif", Font.BOLD, 40));

        contactus = new JLabel("Contact Us");
        contactus.setBounds(370, 100, 440, 80);
        contactus.setForeground(Color.yellow);
        contactus.setFont(new Font("Sans Serif", Font.BOLD, 80));

        l1 = new JLabel("Full Name :");
        l1.setBounds(450, 210, 180, 50);
        l1.setFont(new Font("Sans Serif", Font.BOLD, 20));
        l1.setForeground(Color.yellow);
        f.add(l1);

        l2 = new JLabel("E-mail :");
        l2.setBounds(470, 280, 180, 50);
        l2.setFont(new Font("Sans Sarif", Font.BOLD, 20));
        l2.setForeground(Color.yellow);
        f.add(l2);

        l3 = new JLabel("Message :");
        l3.setBounds(450, 400, 180, 50);
        l3.setFont(new Font("Sans Sarif", Font.BOLD, 20));
        l3.setForeground(Color.yellow);
        f.add(l3);

        l3 = new JLabel("Phone number :");
        l3.setBounds(410, 340, 180, 50);
        l3.setFont(new Font("Sans Sarif", Font.BOLD, 20));
        l3.setForeground(Color.yellow);
        f.add(l3);

        b1 = new JButton("SUBMIT");
        b1.setBounds(480, 520, 100, 40);
        b1.setFont(new Font("Sans Sarif", Font.BOLD, 20));
        b1.setForeground(Color.yellow);
        b1.setBackground(new Color(200, 0, 50));
        b1.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        f.add(b1);
        b2 = new JButton("RESET");
        b2.setBounds(620, 520, 100, 40);
        b2.setFont(new Font("Sans Sarif", Font.BOLD, 20));
        b2.setForeground(Color.yellow);
        b2.setBackground(new Color(200, 0, 50));
        b2.setBorder(BorderFactory.createLineBorder(Color.white, 4));
        f.add(b2);

        // b2 = new JButton("Back");
        // b2.setBounds(555, 540, 100, 40);
        // b2.setFont(new Font("Sans Sarif", Font.BOLD, 18));
        // b2.setForeground(Color.yellow);
        // b2.setBackground(new Color(200, 0, 50));
        // b2.setBorder(BorderFactory.createLineBorder(Color.white, 3));
        // f.add(b2);
        t1 = new JTextField();
        t1.setBounds(580, 220, 190, 30);
        f.add(t1);
        t2 = new JTextField();
        t2.setBounds(580, 290, 190, 30);
        f.add(t2);
        t3 = new JTextField();
        t3.setBounds(580, 350, 190, 30);
        f.add(t3);
        t4 = new JTextField();
        t4.setBounds(580, 410, 190, 80);
        f.add(t4);
        b1.addActionListener(this);
        b2.addActionListener(this);
        f.add(icon);
        f.add(contactus);
        f.add(welcome);
        f.add(name);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createDatabase();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == back) {
//            HomeScreenNew h = new HomeScreenNew();
//        } else 
        if (ae.getSource() == b2) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
        }
        if (ae.getSource() == b1) {

            if (t1.getText().equals("")) {
                JOptionPane.showMessageDialog(f, "Enter your email!");
            } else if (t1.getText().contains("@gmail.com")) {
                JOptionPane.showMessageDialog(null, "Please enter correct email!");
            } else if (t2.getText().equals("")) {
                JOptionPane.showMessageDialog(f, "Enter your Name please!");
            } else if (t3.getText().equals("")) {
                JOptionPane.showMessageDialog(f, "Enter your number please!");
            } else if (t4.getText().equals("")) {
                JOptionPane.showMessageDialog(f, "Enter message to submit!");
            } else {
                try {
                    try (Statement stmt = con.createStatement()) {
                        String fullName = t1.getText();
                        String Email = t2.getText();
                        String phoneNum = t3.getText();
                        String message = t4.getText();
                        String dbop = "INSERT INTO  contact VALUES('" + Email + "', '" + fullName + "','" + phoneNum + "','" + message + "')";
                        stmt.execute(dbop);

                        JOptionPane.showMessageDialog(f, "Request has been sent.");
                        f.dispose();
                        new HomeScreen2();
                        
                        
                    }
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    private void createDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "");

            System.out.println("Database Connection Successfull");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e + " hello");
        }
    }

//    public static void main(String[] args) {
//        new ContactUs2();
//    }
}
