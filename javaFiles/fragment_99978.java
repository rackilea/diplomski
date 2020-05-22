public class Test  {

    public static void main(String[]arghs){

        public static void main(String[]arghs){

            System.out.println("Make a choice : (1), (2), (3)");
            //validation is a scanner already declare elsewhere
            n = validation.nextLine();

            switch (n) {
            case "1":
                //set an object initialized to casevar =7, win =9, loose = 0
                play(new DataObject(7,9, 0)); 
                break;
            case "2":
                play(new DataObject(17,8, 4)); 
                break;
            case "3":
                //do like case "1" / case "2" 
                break;
            default:
                System.out.println("invalid");
            }//end of switch
        }

        //an example of a play method recieving 3 integers. 
        public static void play(){

            System.out.print("Did you win? ( (y)es or (n)o ) ");
            choice = validation.nextLine();
            //follow Aku Nour's answer
        }
    }


    //play method receiving data object 
    public static void play(DataObject data){

        System.out.print("Did you win? ( (y)es or (n)o ) ");
        choice = validation.nextLine();

        //
        casevar++;
    }

    //as  David Wallace proposed 
    //an object containing the 3 parameters you mentioned 
    class DataObject {


        private int casevar; private int win; private int loose;

        DataObject(int casevar, int win, int loose){

            this.casevar = casevar;
            this.win = win; 
            this.loose = loose;
        }

        public int getCasevar() {
            return casevar;
        }

        public void setCasevar(int casevar) {
            this.casevar = casevar;
        }

        public int getWin() {
            return win;
        }

        public void setWin(int win) {
            this.win = win;
        }

        public int getLoose() {
            return loose;
        }

        public void setLoose(int loose) {
            this.loose = loose;
        }
    }

}