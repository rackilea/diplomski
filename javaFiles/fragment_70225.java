import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.stats.Counter;
import edu.stanford.nlp.stats.ClassicCounter;
import edu.stanford.nlp.util.CoreMap;

import java.util.Properties;

public class AdjectiveSentimentExample {

    public static void main(String[] args) throws Exception {

        Counter<String> adjectivePositiveCounts = new ClassicCounter<String>();
        Counter<String> adjectiveNegativeCounts = new ClassicCounter<String>();

        Annotation review = new Annotation("The movie was great!  It was a great film.");
        String sentiment = "positive";

        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        pipeline.annotate(review);
        for (CoreMap sentence : review.get(CoreAnnotations.SentencesAnnotation.class)) {
            for (CoreLabel cl : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                if (cl.get(CoreAnnotations.PartOfSpeechAnnotation.class).equals("JJ")) {
                    if (sentiment.equals("positive")) {
                        adjectivePositiveCounts.incrementCount(cl.word());
                    } else if (sentiment.equals("negative")) {
                        adjectiveNegativeCounts.incrementCount(cl.word());
                    }
                }

            }
        }

        System.out.println("---");
        System.out.println("positive adjective counts");
        System.out.println(adjectivePositiveCounts);
    }
}