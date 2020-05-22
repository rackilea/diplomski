for (int i = 0; i < s.length(); i++) {

    int idexof = from.indexOf(s.charAt(i));
    if (idexof != -1) {
        s = s.replace(s.charAt(i), to.charAt(idexof));   
    }

}
return s;