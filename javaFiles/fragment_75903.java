public class Word {
    String text;
    Article article;

    public Word(String text, Article article) {
        this.text = text;
        this.article = article;
    }

    // other code
}

public class Article
    String content;
    public Article(String content) {
        this.content = content;   
    }

    public int calOccurrence(Word word) {
        // Calculate the occurrence of word.text in this.content
    }

    // other code
}