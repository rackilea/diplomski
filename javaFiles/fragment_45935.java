ArrayList<Integer> array = new ArrayList<Integer>();
    Integer tempInteger;
    try{
        tempInteger = Integer.parseInt(edittext.getText().toString());
    }catch(NumberFormatException e){
        e.printStackTrace();
    }
    array.add(tempInteger);

    /*
     * Once you have your array filled with 'elements' (In your case
     * with Integer values) you can use the following loop called a 
     * 'for-each' loop to loop through ALL the elements in your list.
     */
    for(Integer i : array){
        System.out.println("array["+array.get(i)+"]" + " = " + i);
    }