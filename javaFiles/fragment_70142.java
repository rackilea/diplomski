public int hashCode() {
        //return super.hashCode();

        int result = 13;

        result = 31 * result + ( silent ? 1 : 0); //silent is boolean
        result = 31 * result + msgenum;           //msgenum is int
        result = 31 * result + type;              //type is int
        result = 31 * result + from.hashCode();   //these three are objects
        result = 31 * result + val.hashCode();    //they have valid hashCode()
        result = 31 * result + msg.hashCode();

        return result;
    }