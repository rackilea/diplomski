public Date getNextDay(){
            Date date = new Date();
            try {
                if(day < getMaxDaysInMonth()){
                    date= new Date(day + 1, month, year);
                }
                else if(day == getMaxDaysInMonth() & month < 12){
                    date = new Date(1, month+1, year);
                }
                else if(day == getMaxDaysInMonth() & month == 12){
                    date = new Date(1, 1, year+1);
                }
            } catch (Exception e) {
                System.out.println("You have entered an invalid Date.");
                e.printStackTrace();

            }
            return date;
        }