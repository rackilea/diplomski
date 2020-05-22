public static void main(String[] args) {

  String line = "_xdyjp_bn_qnp_00:00:05,94_00:00:11,41 يلجأ النظام السوري إلى استخدام ذخائر عنقودية لقمع الاحتجاجا";

  String pattern = "(.*?)(\\d.*?)\\s(.*)";

  Pattern r = Pattern.compile(pattern);

  Matcher m = r.matcher(line);
  if (m.find( )) {
     System.out.println("Found value: " + m.group(1) );
     System.out.println("Found value: " + m.group(2) );
     System.out.println("Found value: " + m.group(3) );
  }
}