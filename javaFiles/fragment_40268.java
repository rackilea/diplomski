Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2013);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        int start = cal.get(Calendar.WEEK_OF_YEAR);
        Log.d("BLA BLA", "Value is " + start);
        cal.set(Calendar.YEAR, 2013);
        cal.set(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 28);
        int end = cal.get(Calendar.WEEK_OF_YEAR);
        //Above line will not work for December Month, use following line for this
        int end = isDecember?53:cal.get(Calendar.WEEK_OF_YEAR);
        Log.d("BLA BLA", "Value is " + end);
        Log.d("BLA BLA", "Num weeks:: " + (end - start +1 ));