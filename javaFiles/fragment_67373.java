import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Panel extends JPanel {

    private JPanel monthPanel;
    private JLabel monthYear;
    private final static Color buttonColor = new Color(116, 185, 255), buttonColorInactive = new Color(255,255,255),
                  sundey = new Color(0, 184, 148),  saturday = new Color(85, 239, 196), labelColor = new Color(255, 211, 42);
    private final static int DAYS=7, WEEKS =6;
    private final LocalDate dateNow = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
    private LocalDate calendarDate;
    private final JButton[] buttonArray = new JButton[DAYS*WEEKS];

    Panel(){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(getMonthLabel());
        add(getWeekDaysPanel());
        add(Box.createRigidArea(new Dimension(0,5)));
        makeMonthPanel();
        add(monthPanel);
        calendarGenerator(dateNow);
    }

    private void makeMonthPanel(){

        monthPanel = new JPanel();
        monthPanel.setLayout(new GridLayout(WEEKS,DAYS));
        monthPanel.setPreferredSize(new Dimension(710,460));
        monthPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Loop that in every iteration creates a "b" button set it properties and to a "p" panel and a buttonArray.
        for (int i=0; i< DAYS * WEEKS; i++){
            JButton b = new JButton();
            b.setPreferredSize(new Dimension(95,70));
            b.setBorderPainted(false);
            b.setRolloverEnabled(false);
            JPanel p = new JPanel();
            p.add(b);
            buttonArray[i] = b;
            monthPanel.add(p);
        }
    }

    // Similar to getMonthPanel method - it adds a 7 labels with the names of the days
    private JComponent getWeekDaysPanel(){
        JPanel daysPanel = new JPanel();
        daysPanel.setBackground(labelColor);
        daysPanel.setPreferredSize(new Dimension(700,35));
        String[] daysList = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        for (int i = 0; i < daysList.length ; i++){
            JLabel e = new JLabel("", JLabel.CENTER);
            e.setPreferredSize(new Dimension(95,25));
            e.setText(daysList[i]);
            daysPanel.add(e);
        }
        return daysPanel;
    }
    // a method that adds a two buttons (to switch to previous and next month) and a label that displays the displayed month and year
    private JComponent getMonthLabel(){

        JPanel monthLabel = new JPanel();
        monthLabel.setBackground(buttonColorInactive);

        JButton nextButton = new JButton(">");;
        nextButton.setBorderPainted(false);
        nextButton.setBackground(new Color(255,255,255));
        nextButton.addActionListener(e -> calendarGenerator(calendarDate.plusMonths(1)));

        JButton previousButton = new JButton("<");
        previousButton.setBorderPainted(false);
        previousButton.setBackground(new Color(255,255,255));
        previousButton.addActionListener(e -> calendarGenerator(calendarDate.minusMonths(1)));

        monthYear = new JLabel("MIESIĄC_ROK", JLabel.CENTER);
        monthYear.setPreferredSize(new Dimension(620,25));

        monthLabel.add(previousButton);
        monthLabel.add(monthYear);
        monthLabel.add(nextButton);

        return monthLabel;
    }

    // A method that change the appearance of the buttons in the "buttonArray" so the whole thing looks like calendar of the month
    private void calendarGenerator(LocalDate dateInMonth){
        calendarDate = dateInMonth;
        int noOfDays = dateInMonth.lengthOfMonth(); /// getting number of days in a month
        int firstDayIndex = dateInMonth.getDayOfWeek().getValue() - 1; // gettin the value (number) of the first day of month (it is decreased because getValue starts with 1 and buttonArray with 0)
        int dayNo = 1; // variable that is used to set number of day in the setText() method of button
        int month = dateInMonth.getMonth().getValue() - 1; // variable that has a number of the previous month, that is why I decreased it by 1
        int year = dateInMonth.getYear(); // getting current year

        if (month == 0){ // safety - when the month variable hits 0 it is set for December (no 12) and year is decreased by 1
            month = 12;
            year --;
        }

        LocalDate previousMonthDate = LocalDate.of(year, month, 1); // a new variable for the previous month
        int dayNo2 = previousMonthDate.lengthOfMonth() - (firstDayIndex - 1);  // getting number of days of the previous mont (similar to dayNo but it responsible for the previous month during displaying


        for (int i = 0; i < firstDayIndex; i++){ // loop that fill days in buttons that represent previous month
            buttonArray[i].setText(""+dayNo2);
            buttonArray[i].setEnabled(false);
            buttonArray[i].setBackground(buttonColorInactive);
            dayNo2++;
        }


        for (int i = firstDayIndex; i < noOfDays + firstDayIndex; i++){ // loop that fill days in buttons that represent current month
            buttonArray[i].setText(""+dayNo);
            buttonArray[i].setVisible(true);

            if (i == 6 || i == 13 || i == 20 || i == 27 || i == 34 || i == 41){

                buttonArray[i].setBackground(sundey);
            }
            else if (i == 5 || i == 12 || i == 19 || i == 26 || i == 33 || i == 40){
                buttonArray[i].setBackground(saturday);
            }
            else{
                buttonArray[i].setBackground(buttonColor);
            }
            monthYear.setText(""+dateInMonth.getMonth()+" "+year);
            dayNo++;
        }

        dayNo = 1; // setting dayNo 1 because next month always starts with 1

        for (int i = noOfDays + firstDayIndex; i < 42; i++){ // loop that fills the rest, empty buttons that represent next month
            buttonArray[i].setText(""+ dayNo);
            buttonArray[i].setVisible(true);
            buttonArray[i].setEnabled(false);
            buttonArray[i].setBackground(buttonColorInactive);
            dayNo++;
        }

        monthPanel.revalidate();
    }

    public static void main(String[] args) {

        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel calendarPane = new Panel();
        frame.getContentPane().add(calendarPane);
        frame.pack();
        frame.setVisible(true);
    }
}