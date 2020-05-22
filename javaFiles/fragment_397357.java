public class Route {
    public String getRouteNo() {
        return RouteNo;
    }

    public void setRouteNo(String routeNo) {
        RouteNo = routeNo;
    }

    public String getRouteName() {
        return RouteName;
    }

    public void setRouteName(String routeName) {
        RouteName = routeName;
    }


    public Route(String routeNo, String routeName) {
        RouteNo = routeNo;
        RouteName = routeName;

    }

    private String RouteNo;
    private String RouteName;

    private List<Schedule> schedules;  // add mutators with @JsonProperty annotation

}