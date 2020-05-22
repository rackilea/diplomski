String myConcat(String[] arguments, String separator) {
    StringBuilder output = new StringBuilder();
    for(int i = 0; i < arguments.length; i++){
        output.append(arguments[i]);
        if(i < arguments.length-1){ 
             output.append(separator);
        }
        return output.toString();
    }