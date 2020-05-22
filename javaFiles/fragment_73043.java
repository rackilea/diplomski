View.OnClickListener clickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
                    View customView = inflater.inflate(R.layout.popup, null);
                    ImageView img1 = (ImageView) customView.findViewById(R.id.popup_img);
                    if (v.getId() == R.id.ma1) {
                        img1.setImageResource(R.drawable.ma_bananacho_popup);
                    } else if (v.getId() == R.id.ma2) {
                        img1.setImageResource(R.drawable.chocolate);
                    }
                    myPopUp = new PopupWindow(customView);
                    myPopUp.setWidth(width - 50);
                    myPopUp.setHeight(height - 50);
                    myPopUp.setOutsideTouchable(true);
                    myPopUp.setFocusable(true);
                    myPopUp.showAtLocation(positionPopup, Gravity.CENTER, 0, 0);
                }
            };
            ma1.setOnClickListener(clickListener);
            ma2.setOnClickListener(clickListener);