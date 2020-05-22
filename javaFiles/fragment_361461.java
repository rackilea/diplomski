public static void main(String args[]){

boolean vQs[] = new boolean[args.length];
int vCount=0;

for(int i=0; i<args.length; i++){

    String rawQuestion = args[i];

    if(isValidQuestion(rawQuestion)){


    System.out.println(rawQuestion + " is a valid question!");
            //Here you have enough data to count the valid questions, three loops are not needed.
            ++vCount;
            vQs[i]=true;
        }else{
            System.out.println("Error: " + rawQuestion + ", input must be a word consist of a-z or A-Z");
            vQs[i]=false;
        }
    }

    System.out.println("There are " + vCount + " valid questions");

    //store valid questions into an array
    String questions[] = new String[vCount];

    int j=0;
    for(int i=0; i<args.length; i++){
        //You need to iterate for all strings, because vQs[] is long args.length
        if(vQs[i]){
            //Ok the i-th question was valid, let's move it and print it
            questions[j] = args[i];
            System.out.println( questions[j] );
            ++j;
        }
    }

}