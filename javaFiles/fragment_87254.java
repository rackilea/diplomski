public class Global extends GlobalSettings {

    @Override
    public Result onHandlerNotFound(Http.RequestHeader uri) {
        Iterator<Tuple3<String, String, String>> it = Routes.documentation().iterator();
        while(it.hasNext()){
            if(it.next()._2().equals(uri.uri())){
                return new Results.Status(play.core.j.JavaResults.MethodNotAllowed(), "Your msg", Codec.javaSupported("utf-8"));
            }
        }
        return super.onHandlerNotFound(uri);
    }

}