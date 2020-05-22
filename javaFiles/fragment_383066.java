// If expires date is grater than current one, the Notification IS expired
public static List<Notification> findAllExpired() {
    return find.where().gt("expires", new Date()).findList();
}

// If expires date is lower than current one OR isn't set at all,
// the Notification is valid.
public static List<Notification> findAllNotExpired() {
    return find.where().or(
              Expr.lt("expires", new Date()),
              Expr.isNull("expires")
           ).findList();
}