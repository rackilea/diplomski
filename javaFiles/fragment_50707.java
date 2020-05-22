outerloop: for (int i = 0; i < (dates.length - 1); i = i + 2) {
            Date currentdate1 = dates[i];
            Date endDate1 = dates[i + 1];

            for (int j = i + 2; j < dates.length - 1; j = j + 2) {
                Date currentdate2 = dates[j];
                Date endDate2 = dates[j + 1];

                if ((currentdate1.compareTo(endDate2) <= 0)
                        && (currentdate2.compareTo(endDate1) <= 0)) {
                    System.out.println("Overlapping found:-");
                    print(currentdate2);
                    print(endDate2);
                    break outerloop;

                }
            }
        }