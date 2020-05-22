package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(hello.BuildInfo.name());//the name of the application as output
    }

}