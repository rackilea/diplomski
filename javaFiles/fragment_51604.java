public class Router {
  private Iterable<Route> routes;

  public Router(Iterable<Route> routes) {
    this.routes = routes;
  }
  public void addRoute(Route route) {

    //create new list
    ArrayList<Route> myList = new ArrayList<Route>();

    //iterate through current objects and add them to new list
    Iterator<Route> routeIterator = routes.iterator();
    while(routeIterator.hasNext()){
        myList.add(routeIterator.next());
    }


    //add object you would like to the list
    myList.add(route);

  }
}