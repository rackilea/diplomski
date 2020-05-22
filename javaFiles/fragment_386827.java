public void initAppScreen(final Stage mainStage) {

        loadingWindow = new LoadingWindow().getInitWindow();

        applicationContext = new ClassPathXmlApplicationContext("hibernate-config.xml");

        initSample();

        Platform.runLater(new Runnable() {
            public void run() {

                Scene root = new Scene(new AppWindow().getAppWindow());
                mainStage.setScene(root);

                mainStage.setTitle("My Application Title");
                mainStage.getIcons().add(new Image("/images/logo.png"));
                mainStage.setOnCloseRequest(event -> System.exit(0));

                mainStage.setWidth(APP_WINDOW_WIDTH);
                mainStage.setHeight(APP_WINDOW_HEIGHT);
                mainStage.setMinWidth(APP_WINDOW_WIDTH);
                mainStage.setMinHeight(APP_WINDOW_HEIGHT);

                Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
                mainStage.setX((screenBounds.getWidth() - APP_WINDOW_WIDTH) / 2);
                mainStage.setY((screenBounds.getHeight() - APP_WINDOW_HEIGHT) / 2);

                mainStage.show();
                loadingWindow.dispose();
            }
        });

    }