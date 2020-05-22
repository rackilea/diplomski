public static void main(String[] args) {
    // TODO code application logic here

    String array1[]={"A" , "B" , "C", "D"};
    String array2[]={"a" , "b" , "c", "d"};


    System.out.println("Enter your letter: ");

    try {
        BufferedReader bufferRead =
                new BufferedReader(new InputStreamReader(System.in));

        String input = bufferRead.readLine();

        if(!Arrays.asList(array2).contains(input)){
            System.out.println("There is no \""+input+"\" in array2[]");
        }else{
            int index = Arrays.asList(array2).indexOf(input);                
            System.out.println("Here is the result: "+array1[index]);
        }



    } catch (IOException e) {
        e.printStackTrace();
    }
}