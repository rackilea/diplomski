package edu.stanford.nlp.examples;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.util.*;

import java.util.*;

public class ConstituentExample {

  public static void main(String[] args) {
    // set up pipeline properties
    Properties props = StringUtils.argsToProperties("-props", "StanfordCoreNLP-arabic.properties");
    // set up Stanford CoreNLP pipeline
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    // build annotation for a review
    Annotation annotation =
        new Annotation("...");
    // annotate
    pipeline.annotate(annotation);
    // get tree
    Tree tree =
        annotation.get(CoreAnnotations.SentencesAnnotation.class).get(0).get(TreeCoreAnnotations.TreeAnnotation.class);
    System.out.println(tree);
    Set<Constituent> treeConstituents = tree.constituents(new LabeledScoredConstituentFactory());
    for (Constituent constituent : treeConstituents) {
      if (constituent.label() != null &&
          (constituent.label().toString().equals("VP") || constituent.label().toString().equals("NP"))) {
        System.err.println("found constituent: "+constituent.toString());
        System.err.println(tree.getLeaves().subList(constituent.start(), constituent.end()+1));
      }
    }
  }
}