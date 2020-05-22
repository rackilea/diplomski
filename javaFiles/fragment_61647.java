onTimer(AjaxRequestTarget target) {
    if(newNotifications) {
        target.add(container);
        newNotifications = false;
    }
}