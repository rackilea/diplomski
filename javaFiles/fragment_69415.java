class Event {
    private String description;
    private String title;
    @SerializedName("add_date") private String addDate;

   public getDescription() {
       return description;
   }
}


 public Search(String text){
    try{

        // Snipped (gets the data from the website)

        Gson json = new Gson();
        Event[] events = json.fromJson(resultstring, Event[].class);

        System.out.print(events[0].getDescription());

    }catch(IOException ex){
        Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
    }

}