final StringBuilder builder = new StringBuilder();
String example = "A test string";

for( byte b: example.getBytes()){
    builder.append(Integer.toBinaryString(b).replaceFirst("0*",""));
}   

System.out.println(builder.toString());