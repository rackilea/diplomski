add(new AbstractAjaxTimerBehavior(Duration.ONE_SECOND) {

    @Override
    protected void onTimer(AjaxRequestTarget target) {

        if (isDataLoaded()) {
            stop(target);
            target.add(table);
        }

    }

});