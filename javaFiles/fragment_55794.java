String file="e:\\s.txt";

        try {
            int counterRow = 0;

            String[][] d = new String[1][1];

            BufferedReader bw = new BufferedReader(new FileReader(file));

            List<List<String>> stringListList = new ArrayList<List<String>>();

            String currentLine;

            while ((currentLine = bw.readLine()) != null) {
                if (currentLine != null) {
                    String[] words = currentLine.split(" ");
                    stringListList.add(Arrays.asList(words));
                }
            }

            // Now convert stringListList into your array if needed
            d = Arrays.copyOf(d, stringListList.size());

            for (List<String> stringList : stringListList) {

                String[] newArray = new String[stringList.size()];

                for (int i = 0; i < stringList.size(); i++) {
                    newArray[i] = stringList.get(i);
                }

                d[counterRow] = newArray;

                counterRow ++;
            }

        } catch (Exception e) {
            // Handle exception
        }