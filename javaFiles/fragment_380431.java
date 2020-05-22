public int compareTo(Data another){

    if(inststatus.equals(another.inststatus)){
        return title.compareTo(another.title);
    }
    return inststatus == "present" ? 1: -1;

}