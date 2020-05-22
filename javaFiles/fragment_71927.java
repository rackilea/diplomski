public class SQLDatePickerCellEditor extends DatePickerCellEditor {

    public SQLDatePickerCellEditor() {
        super(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        datePicker.getMonthView().setSelectionModel(new SingleDaySelectionModel());
    }

}