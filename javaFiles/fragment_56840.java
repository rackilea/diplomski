// 1 - Create an instance of a Spring class
PageRequest page = new PageRequest(0, total, Sort.Direction.DESC, "Date");
// 2 - Query a Spring Repository with the Spring Class
Page<MessageLog> messages = logRepo.findAll(page);

// 3 - CUSTOM LOGIC to convert result to custom DTO class
List<MessageLogViewDto> messageList = messages.getContent().stream().map(
        message -> convertDto.toMessageLogView(message)).collect(Collectors.toList());

// 4 - Return a Java standard CompleteableFuture 
return CompletableFuture.completedFuture(messageList);