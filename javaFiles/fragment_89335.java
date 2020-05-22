String[] word = { "Pretty", "Cool", "Weird" };

// Prints [Pretty, Cool, Weird]
tv.setText(Arrays.toString(word));   

// Prints Pretty, Cool, Weird
tv.setText(Arrays.toString(word).replaceAll("\\[|\\]", ""));