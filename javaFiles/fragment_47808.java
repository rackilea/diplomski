//import com.ibm.icu.text.Transliterator;
String greek
       = "'E\u00E9 \u043c\u0430\u0442\u0435\u043c\u0430\u0442\u0438\u043a\u0430";
String id = "Any-Latin; NFD; [^\\p{Alnum}] Remove";
String latin = Transliterator.getInstance(id)
                             .transform(greek);
System.out.println(latin);