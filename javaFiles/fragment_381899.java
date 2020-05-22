Intent i = new Intent(getApplicationContext(), History.class);
        i.putExtra("activity", (int)1);
        i.putExtra("day", mDay);
        i.putExtra("month", mMonth+1);
        i.putExtra("year", mYear);
        startActivity(i);