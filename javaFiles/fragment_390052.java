@RequestMapping(value = "/autocompleteplayer")
@ResponseBody
public List<String> getPlayerSuggestions(){

    List<String> myList;
    //code that fills myList with all of the players' full names from the database, omitted for brevity
    return myList;
}