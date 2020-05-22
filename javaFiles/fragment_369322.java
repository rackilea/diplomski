public class Controller {
    private Model object_;
    public Controller(Model object) {
        object_ = object;
        this.object_.view.object_ = new Model(); // doesn't work.
        // or view.object_ = ....            
       //blah blah blah
    }
    //blah blah blah
}