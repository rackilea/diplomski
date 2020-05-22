String s = "Έχω ένα string που περιέχει κάποιο κείμενο ( στην ελληνική γλώσσα ), "
        + "το οποίο εξήχθη από ένα PDF .\nΠως μπορώ να ιδρύσω ένα συγκεκριμένο κείμενο "
        + "ας πούμε id.name : 123 και στη συνέχεια να αποθηκεύσετε τον αριθμό 123";

  Pattern p = Pattern.compile("id\\.name \\: (\\d+)");
  Matcher m = p.matcher(s);
  if(m.find()){
      System.out.println(m.group(1));
  }