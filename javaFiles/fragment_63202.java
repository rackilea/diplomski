transition = TranslateTransitionBuilder.create()
        .duration(new Duration(10))
        .node(node)
        .interpolator(Interpolator.LINEAR)
        .cycleCount(1)
        .build();

transition.setOnFinished(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent actionEvent) {
        rerunAnimation();
    }
});

rerunAnimation();