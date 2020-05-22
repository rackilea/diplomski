import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Application {
   public static void main(String[] args) {
      new Login();
   }
}

class Login {
   private JFrame frame;// frame of the interface
   private JButton login = new JButton("Login");
   private JPanel panel = new JPanel();

   public Login() {
      makeFrame();
   }

   private void makeFrame() {
      frame = new JFrame("Login");
      frame.setSize(300, 200);
      // !! frame.setVisible(true);
      frame.add(panel);
      panel.add(login);
      login.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Welcome");
            frame.dispose();
            MainScreen s = new MainScreen();
            // s.setVisible(true); // !! get rid of
         }
      });
      frame.setVisible(true);
   }
}

class MainScreen {
   private JFrame frame;// frame of the interface
   private JPanel panel = new JPanel();
   private JPanel left = new JPanel();
   private JPanel center = new JPanel();
   private JPanel top = new JPanel();
   private JButton approve = new JButton("Approve");
   private JButton review = new JButton("Review");
   private JButton employmentCreate = new JButton("Create/Modify");
   private JLabel PR = new JLabel("Personal Records");
   private JLabel ER = new JLabel("Employment Records");
   private JLabel PerR = new JLabel("Perform Review");
   private JLabel AR = new JLabel("Approve Records");
   private JLabel news = new JLabel("There are no news");
   private JLabel empty = new JLabel();
   private JButton logout = new JButton("Logout");
   private JButton personalCreate = new JButton("Create/Modify");
   private JLabel welcome = new JLabel("Welcome:");
   private JLabel userLbl = new JLabel("USERNAME GOES HERE");

   public MainScreen() {
      makeFrame();
   }

   private void makeFrame() {
      frame = new JFrame("Main Screen");
      frame.setSize(650, 550);
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // frame.setVisible(true);
      frame.add(panel);
      panel.setLayout(new BorderLayout());
      panel.add(top, BorderLayout.PAGE_START);
      top.add(welcome);
      top.add(userLbl);
      panel.add(left, BorderLayout.LINE_START);
      left.add(news);
      panel.add(center, BorderLayout.CENTER);
      left.setPreferredSize(new Dimension(200, 150));
      center.setLayout(new GridLayout(5, 2));
      center.add(PR);
      center.add(personalCreate);
      personalCreate.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
         }
      });
      center.add(ER);
      center.add(employmentCreate);
      employmentCreate.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose();
         }
      });
      center.add(PerR);
      center.add(review);
      center.add(AR);
      center.add(approve);
      center.add(empty);
      center.add(logout);
      frame.setVisible(true);
   }
}