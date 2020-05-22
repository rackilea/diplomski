Message message = new Message();
...
...
Forum forum = new Forum();
forum.setId(yourId);
message.setForum(forum);

messageRepository.save(message);