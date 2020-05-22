for (int i = 0; i < phoneNumber.length(); /*intentionally empty*/){
    if (phoneNumber.charAt(i) == '-'){
        phoneNumber.deleteCharAt(i);
    } else {
        ++i;
    }
}