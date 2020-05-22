public class BillForm extends JFrame implements CaptureObserver {
    // Don't forget your constructor
    public BillForm() {
        super();
    }

    @Override
    public void onError(CaptureStream stream, CaptureException exc) {
         // Code
    }
}