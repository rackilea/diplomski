public void addListenerOnRatingBar(View v) {

        ratingBar = (RatingBar) v.findViewById(R.id.ratingBar1);
        txtRatingValue = (TextView) v.findViewById(R.id.txtRatingValue);

        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                boolean fromUser) {

                txtRatingValue.setText(String.valueOf(rating));

            }
        });
      }