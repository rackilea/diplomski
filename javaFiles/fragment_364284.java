String wordNetDicDir = System.getenv("WORD_NET_DICTIONARY");
if (wordNetDicDir != null) {
   dict = new Dictionary(new File(wordNetDicDir));
   dict.open();
} else {
   // throw exception or log error
   ...
}