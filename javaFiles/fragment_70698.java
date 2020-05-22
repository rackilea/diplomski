import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.sentiment.*;
import edu.stanford.nlp.util.*;
import java.util.Properties;

public class SentimentExample {

  public static void main(String[] args) {
    Annotation document = new Annotation("I liked the first movie.  I hated the second movie.");
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,sentiment");
    props.setProperty("parse.binaryTrees","true");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    pipeline.annotate(document);
    for (CoreMap sentence : document.get(CoreAnnotations.SentencesAnnotation.class)) {
      System.out.println("---");
      System.out.println(sentence.get(CoreAnnotations.TextAnnotation.class));
      System.out.println(sentence.get(SentimentCoreAnnotations.SentimentClass.class));
    }
  }
}