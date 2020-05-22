import java.util.Map;
import java.util.Properties;

import edu.stanford.nlp.coref.CorefCoreAnnotations;
import edu.stanford.nlp.coref.data.CorefChain;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;


public class App {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("annotators", "tokenize,ssplit,pos,lemma,ner,parse,dcoref");
        props.put("dcoref.score", true);
        StanfordCoreNLP corefPipeline = new StanfordCoreNLP(props);
        String text = "Barack Obama was born in Hawaii.  He is the president. Obama was elected in 2008.";
        Annotation document = new Annotation(text);
        corefPipeline.annotate(document);
        // Chains is always null
        Map<Integer, CorefChain> chains = document.get(CorefCoreAnnotations.CorefChainAnnotation.class);
        System.out.println(chains);
    }
}