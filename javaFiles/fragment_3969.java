abstract public class ObserveBase extends AppCompactActivity {
    abstract AnimalContract getModel();

    protected AnimalContract a;

    protected void init() {
        a = getModel();
    }

    ... all the common code here...

}