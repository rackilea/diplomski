public static void main(String[] args){
           List<Integer> array = new ArrayList<Integer>();
           Random rand = new Random();
           int num;
           for (int i = 0; array.size() < 7 ; i++){

               num = rand.nextInt(65) + 1;
               if(!array.contains(num)){
                   array.add(num);
               }
           }

           Collections.sort(array);
           System.out.println(array.toString());
           }    
}