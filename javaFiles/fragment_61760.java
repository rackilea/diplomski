public class ABC {
     ...    
     getSaveButton().addClickHandler(
        new ClickHandler() {
            public void onClick(ClickEvent event) {
               saveToDatabase();
            }
        }
     }
     ...