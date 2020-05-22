HomeController homeController = springContext.getBean(HomeController.class);
FXMLLoader fxmlLoader = new FXMLLoader(xxx.getResource("HomeController.fxml"));
fxmlLoader.setController(homeController);
try {
    fxmlLoader.load();
} catch...