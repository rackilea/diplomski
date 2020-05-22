public boolean returnVal=false;

public void checkExist(String name, MyCallback callback) {
       getAllRecordFromServer(new SearchCallback() {
            @Override
            public void onSearchResult(Map<String, Item> itemsMap) {
                  returnVal=true;
                  proceedFurther(itemsMap) //your next lines of code in this method.
            }

            @Override
            public void onSearchError(XMLPacket error) {
             stopProceedFurther(); //show  some error message to user.
            }
        });