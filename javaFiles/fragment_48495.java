package controllers;

import models.Question;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

import static play.data.Form.form;

public class Application extends Controller {

    public Result index() {
        Form<Question> form = form(Question.class);
        return ok(index.render(form));
    }

    public Result post() {
        Form<Question> form = form(Question.class).bindFromRequest();
        Question question = form.get();
        return ok(Json.toJson(question));
    }
}