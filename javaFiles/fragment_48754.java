import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame {

   private JPanel contentPane;

   public String newDate;
   public String myStartEnd;
   public String StartDate;
   public JLabel lblFinalStartDate;
   public JLabel lblFinalEndDate;

   public JPanel panelSearchCriteria = new JPanel();

   public GUI() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 800, 600);
      contentPane = new JPanel();
      setContentPane(contentPane);
      GridBagLayout gbl_contentPane = new GridBagLayout();
      contentPane.setLayout(gbl_contentPane);

      GridBagConstraints gbc_panelSearchCriteria = new GridBagConstraints();
      gbc_panelSearchCriteria.gridx = 0;
      gbc_panelSearchCriteria.gridy = 0;
      contentPane.add(panelSearchCriteria, gbc_panelSearchCriteria);
      GridBagLayout gbl_panelSearchCriteria = new GridBagLayout();
      panelSearchCriteria.setLayout(gbl_panelSearchCriteria);

      JButton btnChooseSDate = new JButton("Choose Date");
      btnChooseSDate.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            String source = new String("Start");
            Calndar startCal = new Calndar(GUI.this, source); // !!
            startCal.setVisible(true); // !!
            String finalDate = startCal.getFinalDate();
            updateDate(finalDate, source); // !!
         }
      });
      GridBagConstraints gbc_btnChooseSDate = new GridBagConstraints();
      gbc_btnChooseSDate.gridx = 1;
      gbc_btnChooseSDate.gridy = 1;
      panelSearchCriteria.add(btnChooseSDate, gbc_btnChooseSDate);
   }

   public GUI(String str, String soE) {
      this();
      updateDate(str, soE);
   }

   public void updateDate(String d, String se) {
      String tempdate = new String(d + "");
      String answer = new String(se + "");

      if (answer.equals("Start")) {
         StartDate = new String(tempdate + "");
         lblFinalStartDate = new JLabel(StartDate);

         GridBagConstraints gbc_lblFinalStartDate = new GridBagConstraints();
         gbc_lblFinalStartDate.insets = new Insets(0, 0, 0, 5);
         gbc_lblFinalStartDate.gridx = 2;
         gbc_lblFinalStartDate.gridy = 1;
         this.panelSearchCriteria.add(lblFinalStartDate, gbc_lblFinalStartDate);

         System.out.println(lblFinalStartDate.getText());

         revalidate(); // !!
         repaint(); // !!
      } else {

      }
   }

   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            GUI frame = new GUI();
            frame.setVisible(true);
         }
      });
   }
}

class Calndar extends JDialog {  // !!

   private JPanel contentPane;
   private JTable table;
   public int realDay, realMonth, realYear, currentMonth, currentYear;
   public JButton btnPrev = new JButton("<<");
   public JButton btnNext = new JButton(">>");
   public JLabel Monthlabel = new JLabel("");

   public int returnedDAY, returnedMONTH, returnedYEAR;
   public String FinalDate;

   public Calndar(GUI gui, final String SoE) { // !!
      super(gui, "Calndar Title", ModalityType.APPLICATION_MODAL); // !!
      setBounds(100, 100, 330, 430);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      contentPane.setLayout(new BorderLayout(0, 0));
      setContentPane(contentPane);

      GregorianCalendar cal = new GregorianCalendar();
      realDay = cal.get(GregorianCalendar.DAY_OF_MONTH);
      realMonth = cal.get(GregorianCalendar.MONTH);
      realYear = cal.get(GregorianCalendar.YEAR);
      currentMonth = realMonth;
      currentYear = realYear;

      JPanel panel = new JPanel();
      contentPane.add(panel, BorderLayout.CENTER);
      GridBagLayout gbl_panel = new GridBagLayout();
      gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
      gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
      gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
      gbl_panel.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
      panel.setLayout(gbl_panel);

      GridBagConstraints gbc_label = new GridBagConstraints();
      gbc_label.insets = new Insets(0, 0, 5, 5);
      gbc_label.gridx = 1;
      gbc_label.gridy = 0;
      panel.add(Monthlabel, gbc_label);

      JScrollPane scrollPane = new JScrollPane();
      GridBagConstraints gbc_scrollPane = new GridBagConstraints();
      gbc_scrollPane.gridwidth = 3;
      gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
      gbc_scrollPane.fill = GridBagConstraints.BOTH;
      gbc_scrollPane.gridx = 0;
      gbc_scrollPane.gridy = 1;
      panel.add(scrollPane, gbc_scrollPane);

      table = new JTable();
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      table.setRowHeight(35);
      table.setCellSelectionEnabled(true);
      table.setModel(new DefaultTableModel(new Object[][] {
            { null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null },
            { null, null, null, null, null, null, null }, }, new String[] {
            "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" }));
      scrollPane.setViewportView(table);

      JPanel panel_1 = new JPanel();
      contentPane.add(panel_1, BorderLayout.SOUTH);

      JButton btnChoose = new JButton("Select");
      btnChoose.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            int row = table.getSelectedRow();
            int col = table.getSelectedColumn();

            if (row == (-1) || col == (-1)) {
               JOptionPane.showMessageDialog(null, "Please Select a Date",
                     "Error", JOptionPane.WARNING_MESSAGE);
            } else {
               returnDate(row, col);
               // !! GUI DS1 = new GUI(getFinalDate(), SoE);
               dispose();
            }
         }
      });
      btnChoose.setMargin(new Insets(5, 20, 5, 20));
      panel_1.add(btnChoose);
      refreshCalendar(realMonth, realYear);
      // setVisible(true);
   }

   public void refreshCalendar(int M, int Y) {
      int nod, som;
      Monthlabel.setText("July");

      GregorianCalendar cal = new GregorianCalendar(Y, M, 1);
      nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
      som = cal.get(GregorianCalendar.DAY_OF_WEEK);

      for (int i = 0; i < 6; i++) {
         for (int j = 0; j < 7; j++) {
            table.setValueAt(null, i, j);
         }
      }

      for (int i = 1; i <= nod; i++) {
         int row = new Integer((i + som - 2) / 7);
         int column = ((i + som - 2) % 7);
         table.setValueAt(i, row, column);
      }

   }

   public String returnDate(int r, int c) {
      returnedYEAR = 2015;
      returnedMONTH = 7;
      returnedDAY = (int) table.getValueAt(r, c);

      FinalDate = new String("" + returnedYEAR + "-" + returnedMONTH + "-"
            + returnedDAY);

      return FinalDate;
   }

   public String getFinalDate() {
      if (FinalDate.equals(null)) {
         String str = new String("None");
         return str;
      } else {
         return FinalDate;
      }
   }
}