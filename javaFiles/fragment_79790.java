public void showNow() { //THIS IS FOR ACTIVITY WITH ACTION BAR
    pn.showAtLocation((Activity)con.getActionBar().getCustomView(), Gravity.NO_GRAVITY, 0, 180);
}

public void showNowNoActBar() { //THIS IS FOR ACTIVITY WITHOUT ACTION BAR
    pn.showAtLocation(con.findViewById(R.id.dummy_hidden_view), Gravity.NO_GRAVITY, 0, 180);
}