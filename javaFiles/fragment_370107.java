String[] stringValues = jTextField1.getText().split("[,]");
int[] numArray= new int[stringValues.length];

    for(int i=0; i<numArray.length; i++){
        numArray[i]= Integer.parseInt(stringValues[i]);
    }