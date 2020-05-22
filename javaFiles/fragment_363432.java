for (int i = -1 + phoneNumber.length(); i >= 0; /*intentionally empty*/){
    if (phoneNumber.charAt(i) == '-'){
        phoneNumber.deleteCharAt(i);
    } else {
        --i;
    }
}