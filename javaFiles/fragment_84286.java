Scene aux2 = new Scene(new StackPane(), 10, 100,
            new LinearGradient(0, 1, 0, 0, true, CycleMethod.REFLECT,
                    new Stop(0, Color.GREEN), new Stop(0.3, Color.YELLOW),
                    new Stop(0.6, Color.BLUE), new Stop(0.9, Color.RED)));

WritableImage snapshot = aux2.snapshot(null);
PhongMaterial material = new PhongMaterial(Color.WHITE);
material.setDiffuseMap(snapshot);