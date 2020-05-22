boolean isOverLapped(Date newStartDate, Date newEndDate, Date existingStartDate, Date existingEndDate) throws NullPointerException{
            if (!((newEndDate.getTime() <= existingStartDate.getTime()) 
               || (newStartDate.getTime() >= existingEndDate.getTime()))) {
                return true;
            } else {
                return false;
            }
        }