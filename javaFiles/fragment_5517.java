Collections.sort(yourList, new Comparator<TestData>() {    
            public int compare(TestData o1, TestData o2) {
                int date1Diff = o1.getActivation().compareTo(o2.getActivation());
                return date1Diff == 0 ? 
                        o1.geTimestamp().compareTo(o2.getTimestamp()) :
                        date1Diff;
            }               
        });