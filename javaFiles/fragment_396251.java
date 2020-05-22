public static boolean isInputNotEmpty(EditText a, EditText b) {
    String a = a.getText().toString();
    String b = b.getText().toString();
    if (a.equals("") && b.equals("")) {
         return false;
    }
    else {
        return true;
    }
}