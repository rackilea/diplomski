public class DateValueFormatter implements IAxisValueFormatter {

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        // Simple version. You should use a DateFormatter to specify how you want to textually represent your date.
        return new Date(new Float(value).longValue()).toString();
    }
    // ...
}