import java.awt.*;
import javax.swing.*;

public class Invest extends JFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Financial Calculator");

        JPanel toppanel = new JPanel(new GridLayout(3, 3, 2, 2));
        frame.add(toppanel, BorderLayout.NORTH);

        String[] columnNames = {"Entry", "Year", "Year", "Year", "Year"};

        Object[][] data = {{"Period Ending:", "2011", "Snowboarding", Integer.valueOf(5), false},
            {"Values in Millions of $", "12-31", "Rowing", Integer.valueOf(3), true},
            {"Revenue:", "46,542", "Knitting", Integer.valueOf(2), false},
            {"Revenue Other:", "-", "Speed reading", Integer.valueOf(20), true},
            {"Total Revenue:", "46,542", "Speed reading", Integer.valueOf(20), true},
            {"Cost of Revenue:", "18,216", "Speed reading", Integer.valueOf(20), true},
            {"Gross Profit:", "28,326", "Speed reading", Integer.valueOf(20), true},
            {"Selling Gen. Admin Expenses:", "12,111", "Speed reading", Integer.valueOf(20), true},
            {"Research & Development:", "-", "Speed reading", Integer.valueOf(20), true},
            {"Depreciation/Amortization:", "-", "Speed reading", Integer.valueOf(20), true},
            {"Total Operating Expense:", "154", "Speed reading", Integer.valueOf(20), true},
            {"Operating Income:", "35,810", "Speed reading", Integer.valueOf(20), true},
            {"Interest Income (Exp.), Net NonOp:", "10,732", "Speed reading", Integer.valueOf(20), true},
            {"Interest/Invest Inc. Non-Operating:", "White", "Speed reading", Integer.valueOf(20), true},
            {"Interest Inc. Net Non-Operating:", "White", "Speed reading", Integer.valueOf(20), true},
            {"Gain/Loss on Sale of Assets:", "White", "Speed reading", Integer.valueOf(20), true},
            {"Other, Net:", "White", "Speed reading", Integer.valueOf(20), true},
            {"Net Income Before Taxes:", "White", "Speed reading", Integer.valueOf(20), true},
            {"Income Tax - Total:", "White", "Speed reading", Integer.valueOf(20), true},
            {"Minority Interest:", "Brown", "Pool", Integer.valueOf(10), false},
            {"Equity In Affiliates:", "Brown", "Pool", Integer.valueOf(10), false},
            {"Accounting Change:", "Brown", "Pool", Integer.valueOf(10), false},
            {"Discontinued Operations:", "Brown", "Pool", Integer.valueOf(10), false},
            {"Extraordinary Items:", "Brown", "Pool", Integer.valueOf(10), false},
            {"Net Income:", "Brown", "Pool", Integer.valueOf(10), false}};

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel bottompanel = new JPanel(new FlowLayout());
        bottompanel.setBackground(new Color(150, 150, 150));

        JButton compute = new JButton("Compute Ratios");
        bottompanel.add(compute);
        frame.add(bottompanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}