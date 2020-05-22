char prev = pin.charAt(0);
for (char ch : pin.substring(1).toCharArray()) {
    if (chr - prev != 1) {
        // Not a sequence
        return false;
    }
    prev = chr;
}
// Is a sequence !
return true;