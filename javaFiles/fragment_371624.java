public class AllFriends {



public static void directFriends(String name,String[]names,String[]numbers, int num){
ArrayList<String> indirect = new ArrayList<String>();

if (num==0){
    for (int i=0;i<names.length;i++){
        if(names[i].equalsIgnoreCase(name)){
            for(int j=0;j<numbers[i].length();j++){
                if(numbers[i].charAt(j)=='1'){
                    System.out.println(name+" is friends with "+names[j]);
                }
            }
        }
    }
}
else
    //Go through names array
    for (int i=0;i<names.length;i++){
        //To see if name entered is the same as a name from the list
        if(names[i].equalsIgnoreCase(name)){
            //For each character in the individual number String
            for(int j=0;j<numbers[i].length();j++){
                //Check if it's a 1(Friends)
                if(numbers[i].charAt(j)=='1'){
                    //Then add this friend to the group of people needed to be friend searched 
                    indirect.add(names[j]);//New stuff
                    //If 
                    if(j==numbers[i].lastIndexOf("1") ) {

                        for(int f=0;f<indirect.size();f++){
                            num--;
                            **directFriends(name,names,numbers,num);
                            System.out.println("Indirect Friends of "+name+":");
                            directFriends(indirect.get(f),names,numbers,num);**

                        }
                    }

                }
            }
        }
    }
}