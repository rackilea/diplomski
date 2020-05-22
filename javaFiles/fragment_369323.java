class View {
   public Model m; 
}
class Controller {
    public Model m;  
}
....
public static void main( String ... args ) { 
     Model m = ... 
     View v = new View();
     Controller c = new Controller();
     v.m = m;
     c.m = m;
}