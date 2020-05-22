public static boolean contains(String s, char value){
    return s != null && s.indexOf(value) > -1;
}

String sVal = "Jeff George";
assertTrue(contains(sVal, 'e'));
sVal = null;
assertFalse(contains(sVal, 'e'));