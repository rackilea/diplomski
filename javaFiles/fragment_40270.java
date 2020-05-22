Calendar cal = Calendar.getInstance();
        for(int i = 0 ; i < 11;i++){
            cal.set(Calendar.YEAR, 2010);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.set(Calendar.MONTH, i);
            int maxWeeknumber = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
            // Month value starts from 0 to 11 for Jan to Dec
            Log.d("LOG","For Month :: "+ i + " Num Week :: " + maxWeeknumber);
        }