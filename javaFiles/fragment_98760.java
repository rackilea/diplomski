Object[] objs = new Object[] { "wow", 1L };
String[] strings = new String[objs.length];
for (int i = 0; i < objs.length; i++) {
    // this can then throw a ClassCastException on this particular object
    strings[i] = (String) objs[i];
}