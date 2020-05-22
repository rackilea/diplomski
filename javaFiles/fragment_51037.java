if (theArrayList.size() > 0) {
            if (myUserSelectedSortedType == SORT_BY_NAME) {
                sortListByName(theArrayList);
            } else if (myUserSelectedSortedType == SORT_BY__DATE) {
                sortListByDate(theArrayList);
            }


            myAdapter = new Adapter(MainActivity.this, theArrayList);
            myListView.setAdapter(myAdapter);
        }


    private void sortListByName(ArrayList<CustomerEvents> theArrayListEvents) {

          Collections.sort(theArrayListEvents, new EventDetailSortByName());
    }


     private class EventDetailSortByName implements java.util.Comparator<CustomerEvents> {
        @Override
        public int compare(CustomerEvents customerEvents1, CustomerEvents customerEvents2) {
            String name1, name2;
            name1 = customerEvents1.getMyCustomerName().toLowerCase().trim();
            name2 = customerEvents2.getMyCustomerName().toLowerCase().trim();
            return name1.compareTo(name2);
        }
    }


     private void sortListByDate(ArrayList<CustomerEvents> theArrayListEvents) {
            Collections.sort(theArrayListEvents, new EventDetailSortByDate()); 
    }



    private class EventDetailSortByDate implements java.util.Comparator<CustomerEvents> {
        @Override
        public int compare(CustomerEvents customerEvents1, CustomerEvents customerEvents2) {
            Date DateObject1 = StringToDate(customerEvents1.getMyDOB());
            Date DateObject2 = StringToDate(customerEvents2.getMyDOB());

            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(DateObject1);
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(DateObject2);

            int month1 = cal1.get(Calendar.MONTH);
            int month2 = cal2.get(Calendar.MONTH);

            if (month1 < month2)
                return -1;
            else if (month1 == month2)
                return cal1.get(Calendar.DAY_OF_MONTH) - cal2.get(Calendar.DAY_OF_MONTH);

            else return 1;
        }
    }


     public static Date StringToDate(String theDateString) {
        Date returnDate = new Date();
        if (theDateString.contains("-")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            try {
                returnDate = dateFormat.parse(theDateString);
            } catch (ParseException e) {
                SimpleDateFormat altdateFormat = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    returnDate = altdateFormat.parse(theDateString);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            try {
                returnDate = dateFormat.parse(theDateString);
            } catch (ParseException e) {
                SimpleDateFormat altdateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    returnDate = altdateFormat.parse(theDateString);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return returnDate;
    }