for (int i = 0; i < list.size(); i++) {
        String[] tArrays = list.get(i).split(" ");
        List<String> line = new ArrayList<>(Arrays.asList(tArrays));
        for (int c = 0; c < wordList.size(); c++) {
            if (wordList.get(c).equals(line.get(i))) { // you get i for indexes corresponding to the sentence element and not `line` elements as created above
                line.remove(i); // i is iterated over the list of sentences in your case 3, would start from i=0
                i--; // you change it to '-1' and get IndexOutOfBounds
                break;
            }
        }//end for
        list.set(i, String.join(" ", line));
    }//end for