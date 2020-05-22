public class MyBean() {
   private HtmlDataTable dt;

   public MyBean() {
      initTable();
   }

   private initTable () {
      dt = new HtmlDataTable();
      //Add here your columns using HtmlColumn
      HtmlColumn hc = new HtmlColumn();

      //You can set colum values using ValueExpression
      //And add column to table using getChildren().add(hc);
      (...)
   }
  //Getters and setters
}