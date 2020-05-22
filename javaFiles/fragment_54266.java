bounded-mailbox {
  mailbox-type = "akka.dispatch.BoundedDequeBasedMailbox"
  mailbox-capacity = 1000
  mailbox-push-timeout-time = 10s
}

akka.actor.mailbox.requirements {
  "akka.dispatch.BoundedDequeBasedMessageQueueSemantics" = bounded-mailbox
}