sqftResult = sqftInput / TSUBO;
        DecimalFormat sqftFormatted = new DecimalFormat("#####.00");
        String out =  sqftFormatted.format(sqftResult); // or whatever you want to print

        //sqftResultAsString = Double.toString(sqftFormatted);
        System.out.println(sqftInput + " is equal to :" + out  + " Tsubo");