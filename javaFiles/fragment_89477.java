@Override
public boolean isValid(TypeToBeValidated value, ConstraintValidatorContext context) {
    String dateTo = value.getDateTo();
    String dateFrom = value.getDateFrom();

    SimpleDateFormat formatter = new SimpleDateFormat(DateUtil.dateFormat);
    Date dateToDate = null;
    Date dateFromDate = null;
    boolean valid = false;
    try {
        dateFromDate = formatter.parse(dateFrom);
        dateToDate = formatter.parse(dateTo);
        valid = !dateToDate.before(dateFromDate) && dateFromDate.before(dateToDate);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    return valid;
}