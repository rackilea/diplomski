package edu.stanford.nlp.examples;

import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.trees.*;
import edu.stanford.nlp.trees.tregex.*;
import edu.stanford.nlp.util.*;

import java.util.*;


public class TregexExample {

  public static void main(String[] args) {
    // set up pipeline
    Properties props = StringUtils.argsToProperties("-props", "StanfordCoreNLP-spanish.properties");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    // Spanish example
    Annotation spanishDoc = new Annotation("...insert Spanish text...");
    pipeline.annotate(spanishDoc);
    // get first sentence
    CoreMap firstSentence = spanishDoc.get(CoreAnnotations.SentencesAnnotation.class).get(0);
    Tree firstSentenceTree = firstSentence.get(TreeCoreAnnotations.TreeAnnotation.class);
    // use Tregex to match
    String nounPhrasePattern = "/grup\\.nom/";
    TregexPattern nounPhraseTregexPattern = TregexPattern.compile(nounPhrasePattern);
    TregexMatcher nounPhraseTregexMatcher = nounPhraseTregexPattern.matcher(firstSentenceTree);
    while (nounPhraseTregexMatcher.find()) {
      nounPhraseTregexMatcher.getMatch().pennPrint();
    }
  }
}