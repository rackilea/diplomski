rule "Find messages by UserXXX"
  when
    topic: Topic()

    $messagesMap: HashMap() from topic.get("messages")
    $messageEntry: Entry($userKey : key matches "User.*") from $messagesMap.entrySet()

  then
    System.out.println("The full username is " + $userKey); 
end