import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewUpdatedByThread {

    public static void main(String[] args) {
        new Controller();
    }
}

//Controller of the MVC pattern."wires" model and view (and in this case also worker)
class Controller{

    public Controller() {

        Model model = new Model();
        View view = new View(model);
        model.registerObserver(view); //register view as an observer to model

        Worker worker = new Worker(model);

        view.getStopBtn().addActionListener(e -> worker.cancel());
    }
}

//view of the MVC pattern. Implements observer to respond to model changes
class View implements Observer{

    private final Model model;
    private final DataPane pane;
    private final JButton stopBtn;

    public View(Model model) {

        this.model = model;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pane = new DataPane();
        frame.add(pane, BorderLayout.CENTER);

        stopBtn = new JButton("Stop");
        frame.add(stopBtn, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    JButton getStopBtn()  { return stopBtn; }

    @Override
    public void onObservableChanged() { //update text in response to change in model
        pane.setText(String.format("%.2f",model.getValue()));
    }

    class DataPane extends JPanel {

        private final JLabel label;

        DataPane() {
            setPreferredSize(new Dimension(200, 100));
            setLayout(new GridBagLayout());
            label = new JLabel(" ");
            add(label);
        }

        void setText(String text){  label.setText(text); }
    }
}

//Model of the MVC pattern. Holds the information view needs
//Notifies observers (in this case View) when model changes
class Model { //you can make it generic Model<T>

    //the value that needs to be updated
    private Double value = 0.;

    // thread safe set for observers
    private final Set<Observer> mObservers = Collections.newSetFromMap(
                                        new ConcurrentHashMap<Observer, Boolean>(0));
    Model() {}

    //set all elements to value
    void changeValue(Double value){
        this.value = value;
        notifyObservers();
    }

    synchronized Double getValue() { return value; }

    synchronized void setValue(Double value) {  this.value = value; }

    //-- handle observers

    // add new Observer - it will be notified when Observable changes
    public void registerObserver(Observer observer) {
        if (observer != null) {
            mObservers.add(observer);
        }
    }

    //remove an Observer
    public void unregisterObserver(Observer observer) {
        if (observer != null) {
            mObservers.remove(observer);
        }
    }

    //notifies registered observers
    private void notifyObservers() {
        for (Observer observer : mObservers) {
            observer.onObservableChanged();
        }
    }
}

//Interface implemented by View and used by Model
interface Observer {
    void onObservableChanged();
}

//Encapsulates thread that does some work on model
class Worker implements Runnable{

    private final Model model;
    private boolean cancel = false;
    private final Random rnd = new Random();

    public Worker(Model model) {
        this.model = model;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while(! cancel){
            model.changeValue(rnd.nextDouble()* 100);  //generate random value
            try {
                TimeUnit.MILLISECONDS.sleep(300); //pause
            } catch (InterruptedException ex) { ex.printStackTrace();   }
        }
    }

    void cancel() { cancel = true;  }
}