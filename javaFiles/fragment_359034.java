public static void main(String[] args) {

        //Actual Answers
        Map<Integer,String> first = new Hashtable<Integer, String>();
        first.put(1,"A");
        first.put(2,"B");
        first.put(3,"C");

        //User Answers
        Map<Integer,String> second = new Hashtable<Integer, String>();
        second.put(1,"A");
        second.put(2,"A");
        second.put(3,"A");
        checkAnswers(first,second);
}

        public static void checkAnswers(Map<Integer,String> first, Map<Integer,String> second){ 
            int chkcount = 0;
            for(Map.Entry<Integer,String> entry: second.entrySet()){
                String actualAnswer = first.get(entry.getKey());
                String givenAnswer = entry.getValue();
                if(givenAnswer != null && actualAnswer != null && givenAnswer.equals(actualAnswer)){
                    chkcount = chkcount + 1;
                }
            }
            System.out.println(chkcount);

        }