when(this.eventRepository.save(Mockito.any(EventPojo.class))
  .thenAnswer(new Answer<EventPojo>(){
       EventPojo pojo = invocation.getArgument(0);
       return pojo;
  }
);