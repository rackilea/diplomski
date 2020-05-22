public static void main(String[] args)
    {
        String sal[]={"val","sa","de","dal","val","sa","de"}; // just an example array of word
        HashSet<String> ss = new HashSet(Arrays.asList(sal)); // any Hash set containing String Element
        System.out.println("HashSet-");
        System.out.println(ss);

        if(ss.add("vald")){ // word does not exists
            System.out.println("Not exist");
            // Do your code here 
        }else{
            //word exist just increase the array couter
        }


    }