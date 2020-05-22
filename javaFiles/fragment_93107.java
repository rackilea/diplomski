for (Element element : roundEnv.getRootElements()) {
        State state = element.getAnnotation(State.class);
        if(state != null) {
            String stage = state.stage();
            System.out.println("The element " + element + " has stage " + stage);
        }
    }