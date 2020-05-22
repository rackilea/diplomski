FXMLLoader loader = new FXMLLoader(getClass().getResource("tab.fxml"));
TabController tabCont = new TabController();
tabCont.setName("Sandro");
loader.setController(tabCont);
try {
   tab.setContent((Node) loader.load());
} catch (IOException ex) {
   System.out.println(ex);
}