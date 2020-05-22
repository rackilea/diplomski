// parse the string "counts" as int, "count"
            int count = Integer.parseInt(counts);
            // for loop executed "count" number of times to skip the words
            for (int x = 0; x < count && s2.hasNext(); x++){
                String b = s2.next();
            }
            // as long as s2 has the next element add the next words to string
            while (s2.hasNext()) {
                c += s2.next();
                c += " ";
            }