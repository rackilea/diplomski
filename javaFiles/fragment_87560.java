private boolean isValidEmail(CharSequence email) {
    if (!TextUtils.isEmpty(email)) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    return false;
}

private boolean isValidPhoneNumber(CharSequence phoneNumber) {
    if (!TextUtils.isEmpty(phoneNumber)) {
        return Patterns.PHONE.matcher(phoneNumber).matches();
    }
    return false;
}