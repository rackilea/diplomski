import java.util.*; 
class EnterNumber{

    public void enter_list_function(){

        Scanner sc = new Scanner(System.in);

        System.out.println("How many numbers would you like to use?"); 

        //Enter the Numbers of amount
        int input = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();

        System.out.println("Great! Please type in your numbers: "); 
        //Input - Numbers of amount
        for(int j =1; j<=input; j++ ){
            int addval = sc.nextInt();
            //Add the enter amount in array
            list.add(addval);

        }

        Iterator itr=list.iterator();  
        while(itr.hasNext()){  
           //get the enter amount from list
           System.out.println(itr.next());  
        }  
    }


    public static void main(String[] args){

        EnterNumber EnterNumber = new EnterNumber();
        EnterNumber.enter_list_function();

    }

}