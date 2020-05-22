soundVolume.valueProperty().addListener(
       (ObservableValue<? extends Number> ov,
                 Number old_val, Number new_val) -> {
    main.setSoundVolume(new_val.doubleValue());
    main.getMediaPlayer().setVolume(main.getSoundVolume());
});