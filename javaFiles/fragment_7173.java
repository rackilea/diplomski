String[] arrSent = sentence.split("\\. ");

for(int i=0; i<arrSent.length; i++) {
    String[] words = arrSent[i].split("\\ ");
    for(int j=0; j<words.length; j++ {
        listWord.add(words[j]);
    }
    listWord.add(null);
}

// Rebuild
StringBuffer output = new StringBuffer();
for (Iterator<String> it = listWord.iterator(); it.hasNext(); ) {
     String val = it.next();
     String nextword = (output.length() > 0 ? " " : "") + val;
     output.append(val == null ? "." : nextword);
}