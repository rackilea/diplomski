public static List<String[]> parseRoutes() {
    scala.Option<play.core.Router.Routes> option = Play.application().getWrappedApplication().routes();
    if (option.isDefined()) {
        play.core.Router.Routes routes = option.get();
        scala.collection.Seq<scala.Tuple3<String, String, String>> doc = routes.documentation();
        scala.collection.Iterator<scala.Tuple3<String, String, String>> it = doc.iterator();

        List<String[]> listOfRoutes = new ArrayList<String[]>();

        while(it.hasNext()) {
            scala.Tuple3<String, String, String> tuple = it.next();
            //tuple._1() is the method and tuple._2() the url... tuple._3() is the controller name
            String[] route = {tuple._1(), tuple._2()};
            listOfRoutes.add(route);
            Logger.debug("route -> " + Arrays.toString(route));  
        }
        return listOfRoutes;
    }
    return null;
}