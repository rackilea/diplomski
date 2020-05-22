public static <T> String dump(List<T> list, String desc, Function<T, String> func) {
    StringBuilder lemma = new StringBuilder();
    String sep = "(";
    for (T t : list) {
       lemma.append(sep).append(desc).append(func.apply(t));
       sep = OPERATOR;
    }
    return lemma.length() == 0 ? "()" : lemma.append(")").toString();
 }