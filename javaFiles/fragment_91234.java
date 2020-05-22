MessageBox.createQuestion()
           .withMessage("Do you want to delete this event ?")
           .withYesButton( () -> {
               calendaringItem.delete(calendaringItem, name.getValue());
               //action
               //action2 ...
           })
           .withNoButton().open();