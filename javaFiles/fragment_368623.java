public static void main(String[] args) {
        System.out.println(new Date()+": Let's start our StackOverflow helper project!");

        List<List<String>> listOfLists=new ArrayList<>();



            listOfLists.add(Arrays.asList("-22","123456","4234","5435345"));
            listOfLists.add(Arrays.asList("-22","-3","-4"));
            listOfLists.add(Arrays.asList("-22","11","Pillow"));

             Collections.sort(listOfLists, new ComparatorClass());           

}