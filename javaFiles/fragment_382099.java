public class FlexTableLabel extends Label implements ClickHandler {
    int id=0;  
    public FlexTableLabel(String text, int id) {
        this.id=id;
        this.setText=text;
        this.addCickHandler(this);
    }

    public void onClick(ClickEvent event) {
        //sends the id to the server, of course you need to replace it with your 
        //service
        yourService.getNewFlexTable(this.id);
    }     
 }