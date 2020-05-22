import java.awt.*;
import java.util.GregorianCalendar;

import javax.swing.*;

public class Calendrier extends JApplet {
    // Instance Variables
    GregorianCalendar calendar = new GregorianCalendar();
    int ranger = 7;
    int colonne = 7;
    String[] semaine = { "Lu", "Ma", "Me", "Je", "Ve", "Sa", "Di" };
    JLabel[][] grid = new JLabel[ranger][colonne];
    JLabel jlblHeure = new JLabel("Heure: " + ""
            + calendar.get(GregorianCalendar.HOUR_OF_DAY) + ":"
            + calendar.get(GregorianCalendar.MINUTE));
    JPanel jpnlCalendar = new JPanel(new GridLayout(7, 7));
    JPanel jpnlHeure = new JPanel(new GridLayout(1, 1));
    int today = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    int daysInMonth = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
    int daysInWeek = calendar.get(GregorianCalendar.DAY_OF_WEEK);

    public void init() {
        // setting grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = new JLabel();
            }

        }
        // grid layout
        Container contenu = getContentPane();
        for (int i = 0; i < ranger; i++) {
            for (int j = 0; j < colonne; j++) {
                jpnlCalendar.add(grid[i][j]);
            }
        }
        // adding JPanels + positions
        contenu.add(jpnlCalendar);
        contenu.add(jpnlHeure, "South");
        jpnlHeure.add(jlblHeure);

        // draw time
        if (calendar.get(GregorianCalendar.MINUTE) < 10) {
            jlblHeure = new JLabel("Heure: " + ""
                    + calendar.get(GregorianCalendar.HOUR_OF_DAY) + ":" + "0"
                    + calendar.get(GregorianCalendar.MINUTE));
        }
        // draw week days
        for (int i = 0; i < semaine.length; i++) {
            grid[0][i].setText(semaine[i]);
        }
        //conditions for the calendar
        calendar.set(GregorianCalendar.DAY_OF_MONTH, 1);
        int daysInWeek = calendar.get(GregorianCalendar.DAY_OF_WEEK) - 1;
        System.out.print(daysInWeek);
        if (daysInWeek == 0)
            daysInWeek = 7;
        calendar.set(GregorianCalendar.DAY_OF_MONTH, today);

        int days = 1;

        for (int k = daysInWeek - 1; k < colonne; k++) {
            grid[1][k].setText(days + "");
            if (days == today)
                grid[1][k].setText(days + "*");
            days++;
        }
        // draw calendar
        for (int i = 2; i <= colonne; i++) {
            for (int j = 0; j < ranger; j++) {
                if (days <= daysInMonth) {
                    grid[i][j].setText(days + "");
                    if (days == today)
                        grid[i][j].setText(days + "*");
                    days++;
                }
            }
        }

    }
}