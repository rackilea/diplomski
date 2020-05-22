public class JtableExample {

     public static void main(String args[]) {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3" },
                { "Row2-Column1", "Row2-Column2", "Row2-Column3" } };
            Object columnNames[] = { "Column One", "Column Two", "Column Three" };
            JTable table = new JTable(rowData, columnNames);

            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.CENTER);
            Border roundedBorder = new LineBorder(Color.black, 5, true); // the third parameter - true, says it's round
            scrollPane.setBorder(roundedBorder);
            frame.setSize(300, 150);
            frame.setVisible(true);

          }


}