TextField usernameTextField = new TextField("", AssetLoader.defaultSkin);
usernameTextField.setPosition(24,73);
usernameTextField.setSize(88, 14);

stage.add(usernameTextField);            // <-- Actor now on stage 
Gdx.input.setInputProcessor(stage);