DoubleBinding binding = Bindings.createDoubleBinding(
                                    () -> Math.cos(Math.toRadians(getRod().getRotate())) * radiusProperty.get(),
                                    getRod().rotateProperty(),
                                    radiusProperty);

curve.startXProperty().bind(binding);