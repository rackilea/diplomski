public ActionErrors validate() {
    ActionErrors errors = new ActionErrors();
    if (...) errors.add("name", new ActionError("error.field.mandatory"));
    if (...) errors.add("surname", new ActionError("error.field.mandatory"));
    return errors;
}