/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semesterproject;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 import javax.swing.*;

 class HomeScreen2 implements ActionListener {
JFrame f;
JButton BookT;
JButton cancel;
JButton Details;
JButton exit;
JButton Contact;
JButton AboutUs;
JLabel label;
JLabel label1;
JLabel label2;

 HomeScreen2() {
// Frame
 f = new JFrame();
 f.setSize(900, 800);
f.setLayout(null);
f.setLocationRelativeTo(null);
 f.setResizable(false);
  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  f.getContentPane().setBackground(new Color(200, 0, 50));
  
  label = new JLabel("User , Welcome To ");
  label.setBounds(120, 100, 440, 40);
  label.setForeground(Color.yellow);
  label.setFont(new Font("Sans Serif", Font.BOLD, 40));
  
  label1 = new JLabel("INTERNATIONAL AIRLINES ");
  label1.setBounds(30, 180, 600, 40);
  label1.setForeground(Color.yellow);
  label1.setFont(new Font("Sans Serif", Font.BOLD, 40));
  
  ImageIcon image = new ImageIcon("dude1.png");
  label2 = new JLabel();
  label2.setBounds(600, 30, 250, 250);
  label2.setIcon(image);
 
  // Buttons
 BookT = new JButton("Book Ticket");
  BookT.setBounds(360, 300, 180, 50);
  BookT.setFont(new Font("Sans Serif", Font.BOLD, 20));
  BookT.setForeground(Color.yellow);
  BookT.setBackground(new Color(200, 0, 50));
  BookT.setBorder(BorderFactory.createLineBorder(Color.white, 3));
  BookT.setFocusable(false);
  
  cancel = new JButton("Ticket Cancel");
  cancel.setBounds(360, 380, 180, 50);
  cancel.setFont(new Font("Black Arial", Font.BOLD, 20));
  cancel.setForeground(Color.yellow);
  cancel.setBackground(new Color(200, 0, 50));
  cancel.setBorder(BorderFactory.createLineBorder(Color.white, 3));
  cancel.setFocusable(false);
  
  Details = new JButton(" Flight Details");
  Details.setBounds(360, 460, 180, 50);
  Details.setFont(new Font("Sans Serif", Font.BOLD, 20));
  Details.setForeground(Color.yellow);
  Details.setBackground(new Color(200, 0, 50));
  Details.setBorder(BorderFactory.createLineBorder(Color.white, 3));
  Details.setFocusable(false);
  
  exit = new JButton("Exit");
  exit.setBounds(360, 540, 180, 50);
  exit.setFont(new Font("Sans Serif", Font.BOLD, 20));
  exit.setForeground(Color.yellow);
  exit.setBorder(BorderFactory.createLineBorder(Color.white, 3));
  exit.setBackground(new Color(200, 0, 50));
  exit.setFocusable(false);
  
  Contact = new JButton("Contact");
  Contact.setBounds(360, 620, 180, 50);
  Contact.setFont(new Font("Sans Serif", Font.BOLD, 20));
  Contact.setForeground(Color.yellow);
  Contact.setBorder(BorderFactory.createLineBorder(Color.white, 3));
  Contact.setBackground(new Color(200, 0, 50));
  Contact.setFocusable(false);
  
  AboutUs = new JButton("About us");
  AboutUs.setBounds(360, 700, 180, 50);
  AboutUs.setFont(new Font("Sans Serif", Font.BOLD, 20));
  AboutUs.setForeground(Color.yellow);
  AboutUs.setBorder(BorderFactory.createLineBorder(Color.white, 3));
  AboutUs.setBackground(new Color(200, 0, 50));
  AboutUs.setFocusable(false);
  
  f.add(BookT);
  f.add(cancel);
  f.add(Details);
  f.add(exit);
  f.add(Contact);
  f.add(AboutUs);
  f.add(label);
  f.add(label1);
  f.add(label2);
  
  f.setVisible(true);
  BookT.addActionListener(this);
  cancel.addActionListener(this);
  Contact.addActionListener(this);
  AboutUs.addActionListener(this);
  Details.addActionListener(this);
  exit.addActionListener(this);
  }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== BookT){
            f.dispose();
            new TicketBooking();
            }
        else if(ae.getSource()==cancel){
                f.dispose();
                 new TicketCancel();
                 }
            else if(ae.getSource()==Details){
                f.dispose();
                 new flights();
                 }
                 else if(ae.getSource()==exit){
                 System.exit(0);
                 }
                 else if(ae.getSource()==AboutUs){
                   f.dispose();
                   new AboutUs();
                  
                    }
                    else if(ae.getSource()==Contact){
                      f.dispose();
                        new ContactUs2();
                        }
        
    }
}
  

//public class HomeScreenNew {
//    public static void main(String[] args) {
//        HomeScreen2 homeScreen = new HomeScreen2();
//    }
//}