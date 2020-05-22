package de.scrum_master.app;

import feign.Param;
import feign.RequestLine;

public interface StackOverflowClient {
    @RequestLine("GET /questions/{questionId}")
    @MeteredRemoteCall
    String getQuestionPage(@Param("questionId") Long questionId);
}