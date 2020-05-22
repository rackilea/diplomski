String pattern = "\\$\\{[^}]*\\}";

String str1 = "This-is-${username}";
System.out.println(str1.replaceAll(pattern, "Tom"));


String str2 = "This-is-${something}-again";
System.out.println(str2.replaceAll(pattern, "Tom"));