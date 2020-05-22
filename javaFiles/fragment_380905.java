String[] aDays = new String[30];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        for (int count = 30; count >= 1; count--) {
            Calendar csd = Calendar.getInstance();
            csd.add(Calendar.DAY_OF_MONTH, -count);
            aDays[30 - count] = (sdf.format(new Date(csd.getTimeInMillis())));      
        }

        //to double check it
        for (int count = 30; count >= 1; count--) {
            System.out.println(aDays[30 - count]);
        }