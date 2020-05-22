private static Date maxDate;
private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

public static void main(String[] args)
{
    Display display = Display.getDefault();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, true));

    /* Set the maximum */
    Calendar cal = Calendar.getInstance();
    cal.set(2014, 0, 0);
    maxDate = cal.getTime();

    final DateTime date = new DateTime(shell, SWT.DATE | SWT.DROP_DOWN);

    /* Listen for selection events */
    date.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            /* Get the selection */
            int day = date.getDay();
            int month = date.getMonth() + 1;
            int year = date.getYear();

            System.out.println(day + "/" + month + "/" + year);

            /* Parse the selection */
            Date newDate = null;
            try
            {
                newDate = format.parse(day + "/" + month + "/" + year);
            }
            catch (ParseException e)
            {
                return;
            }

            System.out.println(newDate);

            /* Compare it to the maximum */
            if(newDate.after(maxDate))
            {
                /* Set to the maximum */
                Calendar cal = Calendar.getInstance();
                cal.setTime(maxDate);
                date.setMonth(cal.get(Calendar.MONTH));
                date.setDay(cal.get(Calendar.DAY_OF_MONTH));
                date.setYear(cal.get(Calendar.YEAR));
            }
        }
    });

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}