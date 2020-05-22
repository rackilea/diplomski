private List<Location> sortLocationList(List<Location> locationArrayList){
    Collections.sort(locationArrayList, new Comparator<Location>(){
        @Override
        public int compare(Location o1, Location o2){
            String s1 = o1.getValue();
            String s2 = o2.getValue();

            if (s1.equalsIgnoreCase(s2))
                return 0;

            String[] tokens1 = s1.split(" ");
            String[] tokens2 = s2.split(" ");

            if (!tokens1[0].equalsIgnoreCase(tokens2[0]))
                return s1.compareToIgnoreCase(s2);

            int number1 = Integer.parseInt(tokens1[1].replaceAll("\\D", ""));
            int number2 = Integer.parseInt(tokens2[1].replaceAll("\\D", ""));

            if (number1 != number2)
                return number1 - number2;

            String suffix1 = tokens1[1].replaceAll("\\d", "");
            String suffix2 = tokens2[1].replaceAll("\\d", "");

            return suffix1.compareToIgnoreCase(suffix2);
        }
    });

    return locationArrayList;
}