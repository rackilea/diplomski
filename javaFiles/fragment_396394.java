for (int i = 0; i < text.length(); i++) {
   String sub = text.substring(0, i);
   if ( sub.charAt(sub.length() - 1) == '§' || (sub.length() > 1 && sub.charAt(sub.length() - 2) == '§' )
      continue;
   states.add();
}