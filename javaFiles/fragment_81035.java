do{
    try {
        triangle = getTriangleDim();
        bError=false;
    } catch (Exception e){
        System.out.println("You did not enter an integer, please enter an integer value");
        // Don't do anything else in here: we will loop back to the beginning again and get new input!
    }
}while (bError);