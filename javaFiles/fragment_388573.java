void middle (String s) {
    println ("<" + s);
    if (s.length () > 2) 
        middle (s.substring (1, s.length () - 1));
    println (s + ">");
}