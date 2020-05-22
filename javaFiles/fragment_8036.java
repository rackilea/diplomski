Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,(calendar.get(Calendar.DAY_OF_WEEK)+1));
        //alternative:
        //calendar.add(Calendar.DAY_OF_WEEK, 1); 
        Date newDate = calendar.getTime();