Calendar firstDate = Calendar.getInstance();
         Calendar lastDate = Calendar.getInstance();
         Date startDate = firstDate.getTime();
         Date endDate = lastDate.getTime();

         long startTime = startDate.getTime();
         long endTime = endDate.getTime();
         long diffTime = endTime - startTime;
         long diffDays = diffTime / (1000 * 60 * 60 * 24);