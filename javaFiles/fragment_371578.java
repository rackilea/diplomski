List<FeedbackTable> feedbacks = ...; // your list of feedbacks

List<FeedbackTable> latestUsersFeedbacks
          = feedbacks.stream()
                     .collect(Collectors.toMap(f -> f.user, 
                                               f -> f, 
                                              (f1, f2) -> f1.feedbackReceivedTime.after(f2.feedbackReceivedTime) ? f1 : f2))
                     .values().stream().collect(Collectors.toList());