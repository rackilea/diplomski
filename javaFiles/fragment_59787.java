String s = "口水雞 hello Ä";

String s1 = Normalizer.normalize(s, Normalizer.Form.NFKD);
String regex = Pattern.quote("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");

String s2 = new String(s1.replaceAll(regex, "").getBytes("ascii"), "ascii");

System.out.println(s2);
System.out.println(s.length() == s2.length());