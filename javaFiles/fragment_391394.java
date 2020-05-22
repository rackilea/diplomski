Flux<String> categoryIds = Flux.just("1", "2", "3");
Flux<QuestionOptions> questionOptions = 
    categoryIds.flatMap(categoryId -> 
         // retrieve questions for each category
         questionService.getQuestions(categoryId)
              // get options for each question 
              .flatMap(question -> optionService.getOptions(question.getId())
              .collectList()
              .map(optionList -> new QuestionOptions(question, optionList))
         ))
    .subscribeOn(Schedulers.elastic()); // retrieve each question on a different thread.