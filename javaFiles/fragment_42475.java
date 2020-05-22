String[][] sample = new String[][]{{"Apple", "Ball"},{"Cat", "Dog"}, {"Elephant, Fish"} };
        String temp = Arrays.deepToString(sample);
        String[] strings = temp.replace("[", "").replace("]", ">").split(", ");
        List<String> stringList = new ArrayList<>();
        List<String[]> tempResult = new ArrayList<>();
        for(String str : strings) {
            if(str.endsWith(">")) {
               str = str.substring(0, str.length() - 1);
               if(str.endsWith(">")) {
                   str = str.substring(0, str.length() - 1);
               }
               stringList.add(str);
               tempResult.add(stringList.toArray(new String[stringList.size()]));
                stringList = new ArrayList<>();
            } else {
                stringList.add(str);
            }
        }
       String[][] originalArray = tempResult.toArray(new String[tempResult.size()][]);