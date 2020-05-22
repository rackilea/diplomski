FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("/view/history.fxml"));
loader.load();
Parent root = loader.getRoot();
Stage s1 = new Stage();
Scene s2 = new Scene(root);
s1.setScene(s2);
s1.setTitle("History");
s1.setResizable(false);

HistoryController historyController = loader.getController();
while ((str = in.readLine())!=null) {
    historyController.tfHistory.appendText(str);       
}

s1.show();