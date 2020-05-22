class MyActor extends Actor {
    import context._

    def receive = {
        case Start: {
            lockActor ! LockRequestMessage
            become(waitForApproval)
        }
    }    

    def waitForApproval = {
        case LockApprovalMessage => {
            //todo: do your thing
        }
    }


}