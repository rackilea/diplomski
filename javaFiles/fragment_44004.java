List<String> thing = new ArrayList<>();
        thing.add("Euro (EUR), 1.359, €");

        String[] currency = new String[thing.size()];
        String[] factor = new String[thing.size()];
        String[] sign = new String[thing.size()];

        for(int i=0;i<thing.size();i++) {
            String parts[] = thing.get(i).split(",");
            currency[i] = parts[0];
            factor[i] =  parts[1];
            sign[i] =  parts[2];
        }

        System.out.println(currency[0] + " " + factor[0] + " " + sign[0]);