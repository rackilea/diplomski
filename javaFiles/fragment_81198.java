import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class KullaniciEkle extends JFrame {

    public static JPanel contentPane;
    public static JTextField textField;
    public static JTextField textField_1;
    public static JTextField textField_2;
    public static JLabel lblIsim;
    public static JLabel lblSoyisim;
    public static JButton btnNewButton = new JButton("Ekle");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    KullaniciEkle frame = new KullaniciEkle();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public KullaniciEkle() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 285, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        textField = new JTextField();
        textField.setBounds(87, 67, 96, 19);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(87, 112, 96, 19);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(87, 160, 96, 19);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));

        btnNewButton.setBounds(93, 232, 85, 21);
        contentPane.add(btnNewButton);

        JLabel lblTc = new JLabel("TC");
        lblTc.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblTc.setBounds(10, 70, 45, 13);
        contentPane.add(lblTc);

        lblIsim = new JLabel("\u0130sim");
        lblIsim.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblIsim.setBounds(10, 115, 45, 13);
        contentPane.add(lblIsim);

        lblSoyisim = new JLabel("Soyisim");
        lblSoyisim.setFont(new Font("Tahoma", Font.PLAIN, 10));
        lblSoyisim.setBounds(10, 163, 45, 13);
        contentPane.add(lblSoyisim);

        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnNewButtonActionPerformed(e);
            }
        });

    }

    private void btnNewButtonActionPerformed(ActionEvent evt) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yasar", "ozkan", "******");

            String input = "INSERT INTO kullanicilar (TC,name,surname) VALUES(?,?,?)";
            try {

                PreparedStatement ps = con.prepareStatement(input);

                ps.setInt(1, Integer.parseInt(textField.getText()));
                ps.setString(2, textField_1.getText());
                ps.setString(3, textField_2.getText());

                //ps.execute();
                if (ps.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "user added", "user add", JOptionPane.OK_CANCEL_OPTION);
                }

            } catch (SQLException f) {
                f.printStackTrace();
            } finally {
                System.out.println("pressed");
            }

            //Instead of frame use this keyword
            this.setVisible(false);
            new GirisEkrani().setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}