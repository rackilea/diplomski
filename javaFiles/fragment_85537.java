import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class Main {
private static int leftWidth, oldWeight;

public static void main(String[] args) {
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());
    shell.setSize(600, 400);

    final SashForm form = new SashForm(shell, SWT.HORIZONTAL);

    final Button button = new Button(form, SWT.PUSH);
    button.setText("Left");

    button.addListener(SWT.Resize, new Listener() {
        @Override
        public void handleEvent(Event arg0) {
            int[] weights = form.getWeights();
            // oldWeights is used to distinguish between a window resize and
            // a sash move
            if (oldWeight != weights[0]) {
                System.out.println("Weights changed!");
                oldWeight = weights[0];
                leftWidth = (int) Math.round((double) form.getClientArea().width
                        * (double) weights[0]
                        / (double) (weights[0] + weights[1]));
            }
        }
    });

    Button buttonR = new Button(form, SWT.PUSH);
    buttonR.setText("Right");

    form.setWeights(new int[] { 200, 800 });
    leftWidth = 200;

    form.addListener(SWT.Resize, new Listener() {
        @Override
        public void handleEvent(Event arg0) {
            int width = form.getClientArea().width;
            int[] weights = form.getWeights();

            double perChange = (double) leftWidth / (double) width;

            weights[0] = (int) (perChange * 1000.0);
            weights[1] = 1000 - weights[0];

            // oldWeights must be set before form.setWeights
            oldWeight = weights[0];
            form.setWeights(weights);
        }
    });

    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}