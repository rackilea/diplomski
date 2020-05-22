public class JDateChooser extends JPanel implements ActionListener,
        PropertyChangeListener {

    protected IDateEditor dateEditor;
    protected JCalendar jcalendar;

    ...

    public void setMinSelectableDate(Date min) {
        jcalendar.setMinSelectableDate(min);
        dateEditor.setMinSelectableDate(min);
    }

    ...
}