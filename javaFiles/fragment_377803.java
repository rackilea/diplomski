package de.scrum_master.app;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import feign.Feign;
import feign.codec.StringDecoder;

public class Application {
    public static void main(String[] args) {
        StackOverflowClient soClient;
        long questionId = 41856687L;

        soClient = new StackOverflowClient() {
            @Override
            public String getQuestionPage(Long loanId) {
                return "StackOverflowClient without Feign";
            }
        };
        System.out.println("  " + soClient.getQuestionPage(questionId));

        soClient = new StackOverflowClient() {
            @Override
            @MeteredRemoteCall
            public String getQuestionPage(Long loanId) {
                return "StackOverflowClient without Feign + extra annotation";
            }
        };
        System.out.println("  " + soClient.getQuestionPage(questionId));

        // Create StackOverflowClient via Feign
        String baseUrl = "http://stackoverflow.com";
        soClient = Feign
            .builder()
            .decoder(new StringDecoder())
            .target(StackOverflowClient.class, baseUrl);
        Matcher titleMatcher = Pattern
            .compile("<title>([^<]+)</title>", Pattern.CASE_INSENSITIVE)
            .matcher(soClient.getQuestionPage(questionId));
        titleMatcher.find();
        System.out.println("  " + titleMatcher.group(1));
    }
}