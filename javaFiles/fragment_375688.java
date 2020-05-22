DAO myDAO = ... ;
String query =  ... ;

myDAO.getSelectList(query, 
    list -> Platform.runLater(() -> {
        // update UI with list ...
    }),
    exc -> Platform.runLater(() -> {
        // handle exception...
    })
);