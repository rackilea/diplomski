DoubleProperty progress = new SimpleDoubleProperty(0);
progText.textProperty().bind(progress.asString());

...
// update progress bar
pb.setProgress(cp*0.0001);
progress.setValue(cp*0.0001)