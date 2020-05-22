BufferedReader text = new BufferedReader(new InputStreamReader(
        System.in));
String text2 = text.readLine();
String[] arr = text2.split(" ");
for (String string : arr) {
    try {
        if (string.length() < 3) {
            age = Integer.parseInt(string);
        } else
            ph_no = Integer.parseInt(string); // supposing phno is below integer range
    } catch (Exception e) {
        name = string;
    }
}
System.out.println("NAME ->" + name);
System.out.println("AGE ->" + age);
System.out.println("PHNO ->" + ph_no);