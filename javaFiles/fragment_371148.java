TextButton button = new TextButton("Text Button", skin);
Table wrapper = new Table();
wrapper.add(button);
wrapper.setTransform(true);
wrapper.setOrigin(wrapper.getPrefWidth() / 2, wrapper.getPrefHeight() / 2);
wrapper.setRotation(45);
wrapper.setScaleX(1.5f);