public Query3 implements Query { 
    Query3(String pageNum`, String pageNum2) {
        this.pageNum1=pageNum1;
        this.pageNum2=pageNum2;
    }

    boolean executeQuery() {
        for(int i = 0; i < users.length; i++ ) {
            SearchThread first = new SearchThread(pageNum1);
            SearchThread second = new SearchThread(pageNum2);
            first.run();
            second.run();
        }
        first.join();
        second.join();
        return first.userCount > second.userCount;
   }

SearchThread extends Thread {
    String pageNumString;
    int userCount;
    SearchThread(String pageNumString) {
        this.pageNumString=pageNumString;
    }
    public void run() {
        // do your search over this segment of the array, adding up userCounts
    }