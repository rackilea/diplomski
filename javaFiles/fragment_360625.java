// you find button in a view 
View popupWindowView = inflater.inflate(R.layout.popup_no_connection, null, false); // this return new view
Button refreshConnection = (Button) popupWindowView.findViewById(R.id.btn_reconnect);

// but you create pop up with another view not from above (which contain listener)
final PopupWindow noConnection = new PopupWindow(
                    inflater.inflate(R.layout.popup_no_connection, null, false),
                    800,
                    800,
                    true);