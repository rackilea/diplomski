public class DateConverter extends StrutsTypeConverter {

    private DateFormat dateFormat;

    {
        ActionContext ctx = ActionContext.getContext();
        ActionSupport action = (ActionSupport) ctx.getActionInvocation().getAction();
        String formatString = action.getText("dateformat.ui");
        dateFormat = new SimpleDateFormat(formatString);
    }

    public Object convertFromString(Map context, String[] values, Class toClass) {
        String input = values[0];
        try {
            Date date = dateFormat.parse(input);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            return cal;
        } catch (ParseException e) {
            return null;
        }
    }

    public String convertToString(Map context, Object object) {
        Calendar cal = (Calendar) object;
        return dateFormat.format(cal.getTime());
    }

}