public static void main(String[] args) throws java.lang.Exception { 

    try(BufferedReader userlines = new BufferedReader(new FileReader("/Users/mona/Documents/Bolzano/Datasets/Lastfm_Matthias/lastfm_usertrackplayer.csv"));) {       
    String uLine = null;

    ArrayList<String> list = new ArrayList<String>();  
    String currentUserId = null;     
    while ((uLine = userlines.readLine()) != null) {

        String[] userData = uLine.split(","); 
        String userId = userData[0]; // <-- get User ID here
        if (userId.equals(currentUserId)) {
            // Do what ever you need while buffering same userId
        } else {
            // Save currentUserId in file
            yourSaveMethod(list);
            currentUserId = userId;
            list.clear();
        }
        list.add(uLine);

        }
    }
}