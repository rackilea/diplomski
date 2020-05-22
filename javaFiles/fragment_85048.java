byte data [] = {9,7,5,3,1,2,4,6,8,4,7,3,9,1,6,5,1,6,7,2,3,6,5,3,8,9,2,1,7,4,2,3,1,9,7,6,8};
    List<byte[]> list = new ArrayList<byte[]>(Arrays.asList(data));

    // outputting your data
    for(byte [] arrayOfByte : list){
    for( byte element : arrayOfByte){
    System.out.println(element);
    }
   }