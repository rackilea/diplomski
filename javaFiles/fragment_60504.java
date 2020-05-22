private List<String> tokenize(String inp) {
    List<String> out = new ArrayList<String>();
    String[] split = inp.split("\\s+|(<br>|<br\\s*/>)+");

    for (String s : split) {
        if (!s.isEmpty()) {
            out.add(s);
        }
    }
    return out;
}