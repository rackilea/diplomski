public boolean handleEvent(Event e){
    try{
        if(e.target instanceof Button){
            if(e.arg.equals("DONE"))
                System.exit(0); //exits the program
        }
    }
    catch(NullPointerException npe){} //catching and swallowing
                                     //the NullPointerException
    return super.handleEvent(e);
}