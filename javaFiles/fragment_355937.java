ArrayList<NameValuePair> lst = new ArrayList<NameValuePair>(); //Instantiate arraylist
    lst.add(new BasicNameValuePair("fruit", "apple")); //add entry
    lst.add(new BasicNameValuePair("animal", "monkey")); //add entry
    String strToCompareAgainst = "apple"; //str to compare to for example
    for(NameValuePair valPair : lst) { //foreach loop
        if(valPair.getValue().equals(strToCompareAgainst)) { //retrieve value of the current NameValuePair and compare
            Log.d("login","moooooo"); //success
        }
    }