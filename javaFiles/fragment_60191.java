try {
    ...// your code
} catch (SQLGrammarException e) {
    for (Throwable ex = e; ex != null; ex = e.getCause())
        ex.printStackTrace();
}