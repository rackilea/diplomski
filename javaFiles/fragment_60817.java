malwareButton.setOnMousePressed(event -> {
                setButtonStylePressed(malwareButton);
                setButtonStyleUnpressed(webShieldButton);
                isButton1Pressed = true;
                isButton2Pressed = false;
                loadTab1Content();
                main.setDefaultViewProperties();
            });