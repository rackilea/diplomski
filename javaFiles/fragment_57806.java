int MAX_WORD_LEN = 22; // making this dynamic left as an excercise
List<PrintWriter> writers = new ArrayList<PrintWriter>();

for (int i = 0; i <= MAX_WORD_LEN; i++) {
    PrintWriter w = new PrintWriter("dictionary_length" + i + ".txt", "UTF-8");
    writers.Add(w);
}

String line;
while ((line = tr.readLine()) != null) {
   int len = line.length();
   if (len < writers.size()) {
       writers.get(len).println(line);
   }
}

for (PrintWriter w : writers) {
    w.close();
}