int count = 0;
                while (count < set1.size()) {
                    boolean inList = false;
                    int count2 = 0;
                    while (inList == false && count2 < set2.size()) {
                        if (set1.get(count).equals(set2.get(count2))) {
                            inList = true;
                        }
                        count2++;
                    }
                    if (!inList) {
                            set3.add(set1.get(count));
                    }
                    count++;
               }