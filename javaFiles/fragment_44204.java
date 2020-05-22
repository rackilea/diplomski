public class Controllers {

        private static MainController mainController;

        public static MainController getMainController() {
            return mainController;
        }

        public static void setMainController(MainController mainController) {
            Controllers.mainController = mainController;
        }

        public static void setMainControllerLoader(FXMLLoader mainControllerLoader) {
            Controllers.mainController = mainControllerLoader.getController();
        }
}