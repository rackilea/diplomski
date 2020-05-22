public class HeadingView extends View {

    public HeadingView(Context context) {
        super(context);

        YourActivity activity = (YourActivity) context;
        activity.addWeekSensorObserver(this);
    }
}