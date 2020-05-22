Calendar tc = Calendar.getInstance();
        Calendar rc = Calendar.getInstance();

        Calendar upperBound, lowerBound;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        upperBound = (Calendar) rc.clone();
        upperBound.add(Calendar.MINUTE, 1);
        lowerBound = (Calendar) rc.clone();
        lowerBound.add(Calendar.MINUTE, -1);

        //Actual values
        System.out.println("test " + dateFormat.format(tc.getTime()));
        System.out.println("UpperB " + dateFormat.format(upperBound.getTime()));
        System.out.println("LowerB " + dateFormat.format(lowerBound.getTime()));
        //Tests
        System.out.println("test after " + tc.after(lowerBound));
        System.out.println("test before " + tc.before(upperBound));