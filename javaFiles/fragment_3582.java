String line=" 1.d4 Nf6 2.c4 g6  0-1]";
        String[] elements = line.split("[\\s.]+");
        List<String> sts  = new ArrayList<>();
        for(String st : elements) {
            if(st.matches(".*[a-z].*"))
                sts.add(st);
        }
        System.out.println(sts);