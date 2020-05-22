import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelTable2 extends JPanel {
    private String data[][];
    private String columns[];
    private int numberOfRows;
    private int numberOfColumns;
    private JTextArea[] header;
    private JTextArea[][] cell;
    final int[] columnsWidth = { 300, 100, 50, 300, 50 };


    public PanelTable2(String data[][], String columns[]) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.data = data;
        this.columns = columns;


        numberOfRows = data.length;
        numberOfColumns = columns.length;

        makeHeader();
        makeCells();
    }

    public void makeCells() {
        cell = new JTextArea[numberOfRows][numberOfColumns];
        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            add(getRow(numberOfColumns, rowIndex));
        }
    }

    public void makeHeader() {
        header = new JTextArea[numberOfColumns];


        for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
            JTextArea ta = new JTextArea();
            ta.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); 
            ta.setPreferredSize(new Dimension(columnsWidth[columnIndex], ta.getHeight())); 
            ta.setBackground(new Color(57, 77, 112));
            ta.setForeground(Color.WHITE);
            ta.setText(columns[columnIndex]);
            ta.setFont(new Font("Calibri Light", Font.BOLD, 25));
            ta.setLineWrap(true);

            ta.setWrapStyleWord(true);
            ta.setEditable(false);
            header[columnIndex] = ta;
        }

        JPanel rowHeader = new JPanel();
        rowHeader.setLayout(new BoxLayout(rowHeader, BoxLayout.X_AXIS));

        for (int i = 0; i < numberOfColumns; i++) {
            rowHeader.add(header[i]);
        }
        add(rowHeader);
    }


    public Component getRow(int numberOfColumns, int rowIndex) {

        JPanel row = new JPanel();
        //use GridLayout if you want equally spaced columns
        row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
        for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
            row.add(getCell(rowIndex, columnIndex));
        }
        return row;
    }

    public Component getCell(int rowIndex, int columnIndex) {
        if (cell[rowIndex][columnIndex] == null) {
            JTextArea ta = new JTextArea();
            ta.setLineWrap(true);
            ta.setWrapStyleWord(true);
            ta.setEditable(false);

            ta.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
            ta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            ta.setText(data[rowIndex][columnIndex]);
            ta.setFont(new Font("Bmitra", Font.BOLD, 15));
            ta.setPreferredSize(new Dimension(columnsWidth[columnIndex], ta.getHeight())); 

            cell[rowIndex][columnIndex] = ta;
        }

        return cell[rowIndex][columnIndex];
    }

}