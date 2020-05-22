package es.phoneixs;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import es.phoneixs.MyClass;


public class Visualizador extends JLabel implements
        ListCellRenderer<Object> {

    public Visualizador() {

        setOpaque(true);
        setVerticalAlignment(CENTER);

    }

    @Override
    public Component getListCellRendererComponent(
            JList<? extends Object> list,
            Object value, int index, boolean isSelected,
            boolean cellHasFocus) {

        this.setFont(list.getFont());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        if (value == null || (value instanceof String && value.equals(" "))) {

            this.setText("No usar la plantilla");

        } else if (value instanceof MyClass) {

            this.setText(String.format("%1$s - %2$s - %3$s",  value.getDescripcionCas(), value.getCodigo(), value.getTurno()));

        } else {
            this.setText(value.toString());
        }

        return this;

    }

}