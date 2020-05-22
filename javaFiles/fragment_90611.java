String[] sentences = new String[]{"Sentence 1", "Sentence 2", "Sentence 3", "Sentence 4", "Sentence 5"};
int clickCount = 0;
public void mostrarMensagem(View view) {
     Toast.makeText(this, sentences[clickCount], Toast.LENGTH_LONG).show();
     clickCount = ++clickCount % sentences.length();
}