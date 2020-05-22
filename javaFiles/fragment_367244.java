package com.stackoverflow.spring.boot.async;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.concurrent.Callable;

@Controller
public class AsyncController {
  @RequestMapping(path = "/AsyncRequest", method = RequestMethod.GET)
  @ResponseBody
  public Callable<String> asyncRequest() {
    return () -> {
      final long currentThread = Thread.currentThread().getId();
      final Date requestProcessingStarted = new Date();

      Thread.sleep(6000L);

      final Date requestProcessingFinished = new Date();

      return String.format(
          "request: [threadId: %s, started: %s - finished: %s]"
          , currentThread, requestProcessingStarted, requestProcessingFinished);
    };
  }
}