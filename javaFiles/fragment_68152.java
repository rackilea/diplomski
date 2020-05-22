String str = "1|2|3#1|2";
String[] strs = str.split("#");
String[][] result = new String[strs.length][];
for (int i = 0; i < strs.length; ++i) {
    result[i] = strs[i].split("\\|");
}