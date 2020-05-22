Calendar cal = Calendar.getInstance();
        for(int i = 0 ; i < 11;i++){
            cal.set(Calendar.YEAR, 2013);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            cal.set(Calendar.MONTH, i);
            int maxWeeknumber = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
            Log.d("LOG","max week number" + maxWeeknumber);
        }

        01-22 01:49:03.591: D/LOG(573): max week number5
        01-22 01:49:03.602: D/LOG(573): max week number5
        01-22 01:49:03.602: D/LOG(573): max week number6
        01-22 01:49:03.671: D/LOG(573): max week number5
        01-22 01:49:03.671: D/LOG(573): max week number5
        01-22 01:49:03.671: D/LOG(573): max week number6
        01-22 01:49:03.681: D/LOG(573): max week number5
        01-22 01:49:03.691: D/LOG(573): max week number5
        01-22 01:49:03.691: D/LOG(573): max week number5
        01-22 01:49:03.711: D/LOG(573): max week number5
        01-22 01:49:03.711: D/LOG(573): max week number5