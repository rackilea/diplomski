package edu.stanford.nlp.examples;

import edu.stanford.nlp.util.*;
import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.ling.tokensregex.Env;
import edu.stanford.nlp.ling.tokensregex.TokenSequencePattern;
import edu.stanford.nlp.ling.tokensregex.TokenSequenceMatcher;
import edu.stanford.nlp.pipeline.*;

import java.util.*;

public class TokensRegexExactMatch {

  public static void main(String[] args) {
    Properties props = new Properties();
    props.setProperty("annotators", "tokenize");
    StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
    Annotation annotation = new Annotation("Training & Courses");
    pipeline.annotate(annotation);
    //System.err.println(IOUtils.stringFromFile("course.rules"));
    Env env = TokenSequencePattern.getNewEnv();
    env.bind("$EDU_WORD_ONE", "/Education|Educational|Courses/");
    env.bind("$EDU_WORD_TWO", "/Background|Qualification/");
    TokenSequencePattern pattern = TokenSequencePattern.compile(env, "$EDU_WORD_ONE $EDU_WORD_TWO?");
    List<CoreLabel> tokens = annotation.get(CoreAnnotations.TokensAnnotation.class);
    TokenSequenceMatcher matcher = pattern.getMatcher(tokens);
    // matcher.matches()
    while (matcher.find()) {
      System.err.println("---");
      String matchedString = matcher.group();
      List<CoreMap> matchedTokens = matcher.groupNodes();
      System.err.println(matchedTokens);
    }
  }
}