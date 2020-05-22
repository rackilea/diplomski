public  List<WeekViewEvent> loadDateFromJson(int year , int month) {
        DBconexion dBconexion = new DBconexion(this);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdfD = new SimpleDateFormat("yy-MM-dd");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdfT = new SimpleDateFormat("HH:mm");
        try {
            JSONObject jo = dBconexion.getDateTime();
            JSONArray Datejason = jo.getJSONArray("Date");
            JSONArray Timejason = jo.getJSONArray("Time");
            JSONArray endTimejason = jo.getJSONArray("End Time");
            JSONArray Namejason = jo.getJSONArray("Name");
            for (int i = 0; i < Datejason.length(); i++) {
                //set date
                String sd = (String) Datejason.get(i);
                Date dfj = sdfD.parse(sd);
                int Day = dfj.getDate();
                int Month = dfj.getMonth() - 0;
                int Year = dfj.getYear();
                //set time
                String st = (String) Timejason.get(i);
                Date tfj = sdfT.parse(st);
                int Hour = tfj.getHours();
                int Minute = tfj.getMinutes();
                String endTimeP = (String) endTimejason.getString(i);
                int endTimePeriod = Integer.valueOf(endTimeP);
                //set name
                String Name = (String) Namejason.getString(i);
                //Rand Colors for Events
                Random rand = new Random();
                int r = rand.nextInt(255);
                int g = rand.nextInt(255);
                int b = rand.nextInt(255);
                int randomColor = Color.rgb(r,g,b);
                if(Color.rgb(r,g,b) == getResources().getColor(R.color.white)){
                   randomColor = getResources().getColor(R.color.red);
                }
                //Set StarTime
                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, Hour);
                startTime.set(Calendar.MINUTE, Minute);
                startTime.set(Calendar.YEAR, year);
                startTime.set(Calendar.MONTH, Month);
                startTime.set(Calendar.DAY_OF_MONTH, Day);
                Calendar endTime = (Calendar) startTime.clone();
                endTime.add(Calendar.HOUR_OF_DAY, endTimePeriod);
                WeekViewEvent weekViewEvent = new WeekViewEvent(1, Name, startTime, endTime);
                weekViewEvent.setColor(randomColor);
                myEvent.add(weekViewEvent);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
       return  myEvent;

    }