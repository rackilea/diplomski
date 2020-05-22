int start = email.indexOf("@");

if (start < 0) {
    return "";  // pick your poison for the error condition
}

StringBuilder sbEmail = new StringBuilder(email);
sbEmail.replace(0, start, "******");
return sbEmail.toString();