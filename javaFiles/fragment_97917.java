//find any 6 digit number
Pattern mPattern = Pattern.compile("(|^)\\d{6}");

if(message!=null) {
    Matcher mMatcher = mPattern.matcher(message);
    if(mMatcher.find()) {
        String otp = mMatcher.group(0);
        Log.i(TAG,"Final OTP: "+ otp);
    }else {
        //something went wrong
        Log.e(TAG,"Failed to extract the OTP!! ");
    }
}