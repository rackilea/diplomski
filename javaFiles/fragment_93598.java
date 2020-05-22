@Override
public void start(Stage primaryStage) {
    Dialog<String> dialog = new Dialog<>();
    dialog.getDialogPane().getButtonTypes().setAll(ButtonType.OK);
    dialog.setResultConverter(ButtonType::getText);
    String result = dialog.showAndWait().orElse(null);
    System.out.println(result);
}