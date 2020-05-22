public static void main(String[] args) {
        String input = "test bla [ABC56465:asd] asdasdqwd [DEF:345]";
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher match = pattern.matcher(input);
        while(match.find()){
            System.out.println(match.group());
        }
    }