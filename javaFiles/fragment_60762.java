String string = "123454466666666666666665454545454454544598989899545455454222222222222222";
int count = 0;
for (int i = 0; i < string.length(); i++) {
    count += Integer.parseInt(String.valueOf(string.charAt(i)));
}
System.out.println(count);