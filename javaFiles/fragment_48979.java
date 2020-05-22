public boolean myMethod() {

    if(boolean condition) {
        return false;
    }
     //some code here;
     return true;
}


switch(int blaah) {
    case 1: 
        some code here;
        break;
    case 2: 
        if (myMethod()) {
            //some code here; //Execute only if the method signalled to do so
        }
        break;
    default:
        some code here;
}