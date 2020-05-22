StringBuilder sb = new StringBuilder();

sb.append(String.format("%-25s%s", "abc","2"));
sb.append(String.format("%-25s%s", "asdf","4"));
sb.append(String.format("%-25s%s", "qwer xyz","5"));

tv.setText(sb.toString());   //tv is a text view