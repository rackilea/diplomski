for(int k = 0; k < 8;k++) {
            spannableString1 = new SpannableString("Destination: " + canningTownArrivals1.get(k).destinationName); //spannable string is in the scope of the for loop,

            spannableString1.setSpan(createClickableSpan(canningTownArrivals1.get(k).currentLocation),0,canningTownArrivals1.get(k).length() + 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            textViewResult1.append(spannableString1);
            textViewResult1.append(
                    "\nTime: " + canningTownArrivals1.get(k).timeToStation + " mins\n");

            textViewResult1.setMovementMethod(LinkMovementMethod.getInstance());
            }


private ClickableSpan createClickableSpan(final String location) {
    return new ClickableSpan() {
        @Override
        public void onClick(@NonNull View widget) {
            Toast.makeText(CanningTownActivity.this,location,Toast.LENGTH_LONG)
                    .show();
        }
    };
}