public static void main(String[] args) {
        String[] inputs = new String[] {
                "PIT  ",
                "       Finals 1  ",
                "PREDICTIONS  ",
            "   Match 2  ",
            "   Quarters 1 Match 1  ",
            "   Quarters 1 Match 2  ",          
            "   Match 1  ",
        "       Semis 1  Match 1 ",
        "       Semis 2   Match 1",
        "       Finals 2",
        "   Quarters 2 Match 1  "};

        List<MatchDescription> c = new ArrayList<>();
        for (String input : inputs) {
            c.add(new MatchDescription(input));
        }
        Collections.sort(c);

        for (MatchDescription e : c) {
            System.out.println(e);
        }

    }
}