SimpleDateFormat myFormat = new SimpleDateFormat("ddMMyyyy");
        List<String> start = Arrays.asList("01011992", "01012001", "01012001");
        List<String> end = Arrays.asList("02012001", "02012001", "01012011");



        int lastIndex =0;
        long lastValue =0;
        for (int i = 0; i < start.size(); i++) {
            String dateBeforeString = start.get(i);
            String dateAfterString = end.get(i);
            try {
                Date dateBefore = myFormat.parse(dateBeforeString);
                Date dateAfter = myFormat.parse(dateAfterString);
                long difference = dateAfter.getTime() - dateBefore.getTime();
                long daysBetween = (difference / (1000 * 60 * 60 * 24));


                if(lastValue<daysBetween){
                    lastValue=daysBetween;
                    lastIndex = i;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("result: " +  start.get(lastIndex)+"-"+end.get(lastIndex)+" maxDiff "+lastValue);