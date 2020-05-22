public class ViewController {
    Model m;
    CommonView v;
    ViewController(){
        m = new Model();
    }


    public void SetViewSwing(){
        v = new View(this);

    }

    public void SetViewKonsoll(){
        v = new ViewKonsoll(this);

    }
}