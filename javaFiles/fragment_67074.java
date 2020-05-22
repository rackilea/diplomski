for(final String s2: test2){
    for (final String s: test){
        if(s.contains(s2)) {
            System.out.println("Match");
        }
    }
}