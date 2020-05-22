package controllers;

import models.RecurOrderJSON;
import ninja.Context;
import ninja.Result;

public class RecurringController {
    public Result processRecurring(Context context, RecurOrderJSON recurOrderJSON) {
        log.info("recurOrderJSON => " + recurOrderJSON);
        return ninja.Results.ok();
    }
}