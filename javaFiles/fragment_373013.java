public void onClick(View view) {
    switch (view.getId()) {
        case R.id.seat_1:
        {
            if (doesExist("1")){
                view.setBackgroundColor(Color.BLACK);
            } else {
                view.setBackgroundColor(Color.YELLOW);
                seats.add("1");
            }
            break;
        }
        case R.id.seat_2: {
            if (doesExist("2")){
                view.setBackgroundColor(Color.BLACK);
            } else {
                view.setBackgroundColor(Color.RED);
                seats.add("2");
            }
            break;
        }
        case R.id.seat_3: {
            if (doesExist("3")){
                view.setBackgroundColor(Color.BLACK);
            } else {
                view.setBackgroundColor(Color.BLUE);
                seats.add("3");
            }
            break;
        }
    }

}