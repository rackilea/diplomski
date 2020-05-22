// Your observable class
import java.util.Observable;
public class ObservableValue extends Observable
{
    private int n = 0;
    public ObservableValue(int n)
    {
        this.n = n;
    }
    public void setValue(int n)
    {
        this.n = n;
        setChanged();
        notifyObservers();
    }
    public int getValue()
    {
        return n;
    }
}


// Your observer
import java.util.Observer;
import java.util.Observable;
public class TextObserver implements Observer {
    private ObservableValue ov = null;
    public TextObserver(ObservableValue ov) {
        this.ov = ov;
    }
    public void update(Observable obs, Object obj) {
        if (obs == ov) {
            System.out.println(ov.getValue());
        }
    }
}


public class Main {
    public Main() {
        ObservableValue ov = new ObservableValue(0);
        TextObserver to = new TextObserver(ov);
        ov.addObserver(to);
    }
    public static void main(String [] args) {
        Main m = new Main();
    }
}