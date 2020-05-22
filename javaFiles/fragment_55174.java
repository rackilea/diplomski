String[] st="[a\\m]".replaceAll("^[!\\[,?._'@+\\]\\s\\\\]+", "")
                 .split("[!\\[,?._'@+\\]\\s\\\\]+");
System.out.println(st.length);
for(String z:st) {
    System.out.println(z);
}