public boolean objectWriter(List<Object> input, String sheetName, int startingRow, String tag){
    ArrayList<Object> myList = new ArrayList<>();
    ArrayList<Method> methodList = new ArrayList<>();
    jxl.write.Number number;
    Label label;

    //This is just an internal counter since we're using a for-each loop. 
    int j;
    try{
        for (int i = 0; i < input.size(); i++){
            j = 0;
            //we want to iterate over all of the available methods in the given class with reflection
            for (Method m: input.get(i).getClass().getDeclaredMethods()){
                //Check to see if the method name has our requested tag, plus the appropriate counter
                //tacked on, and ZERO parameters, in our case.
                if (m.getName().startsWith((tag + j))){
                    //Invoke the method, give it's return value to r (return)
                    final Object r = m.invoke(input.get(i));
                    //Since we defined in the requirements of this class that it must be a string
                    //those types of methods returned, this works just fine, just case it to
                    //String (Since String extends object) and call it a day. 
                    if (isNumeric((String)r)){
                        //if it's a number, make a number object out of it. 
                        number = new jxl.write.Number(j, startingRow + i
                        , Double.parseDouble((String)r)
                        , buildNumberFormat((String)r));

                        myList.add(number);
                    }else{
                        label = new Label(j,startingRow + i,(String)r);
                        myList.add(label);
                    }
                    j++;
                }else{
                    methodList.add(m);
                    for (int x = 0; x < methodList.size(); x++){
                        if (methodList.get(x).getName().startsWith((tag + j))){
                            //Invoke the method, give it's return value to r (return)
                            final Object r = methodList.get(x).invoke(input.get(i));
                            //Since we defined in the requirements of this class that it must be a string
                            //those types of methods returned, this works just fine, just case it to
                            //String (Since String extends object) and call it a day. 
                            if (isNumeric((String)r)){
                                //if it's a number, make a number object out of it. 
                                number = new jxl.write.Number(j, startingRow + i
                                , Double.parseDouble((String)r)
                                , buildNumberFormat((String)r));

                                myList.add(number);
                            }else{
                                label = new Label(j,startingRow + i,(String)r);
                                myList.add(label);
                            }
                            j++;
                            //methodList.remove(x);
                            break;
                        }
                    }
                }
            }
        }
    }catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException ex){
        myLog.error("There was an error working through the point class with reflection.", ex);
        return false;
    }
    boolean successfulWrite = myExcelWriter.writeInformation(myList, sheetName);
    myExcelWriter.resizeColumns(18, sheetName);
    return successfulWrite;

}