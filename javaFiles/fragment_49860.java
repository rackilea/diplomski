public static String replacePronouns(String text, ArrayList<String> dictionary) {
        String[] strArray = text.replaceAll("\\.", " .").replaceAll("\\,", "").split("\\s+");
        String previousName = "";
        for (int i = 0; i < strArray.length; i++) {
            boolean flag = false;
            // we'll have to set this to be more dynamic -> change to pronouns in dicitonary
            if (strArray[i].equals("His") || strArray[i].equals("She") || strArray[i].equals("she") || strArray[i].equals("him") || strArray[i].equals("he") || strArray[i].equals("her")) {
                for (int j = (i - 1); j >= 0 && flag == false; j--) {
                    int count = dictionary.size() - 1;
                    while (count >= 0) {
                        if (strArray[j].equals(dictionary.get(count).split(": ")[1]) && dictionary.get(count).split(": ")[0].equals("Name")) {
                            previousName = strArray[j];
                            flag = true;
                        }
                        count--;
                    }
                }
                strArray[i] = previousName;
            }
        }
        return Arrays.toString(strArray).replaceAll("\\[", "").replaceAll("\\,", "").replaceAll("\\]", "");
    }