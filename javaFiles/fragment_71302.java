String str = "T 10 5.7";
String[] strings = str.split(" ");
for (String string : strings) {
    try {
        System.out.println(Integer.parseInt(string));
    } catch (Exception e) {
        try {
            System.out.println(Float.parseFloat(string));
        } catch (Exception e2) {
            System.out.println(string);
        }
    }
}