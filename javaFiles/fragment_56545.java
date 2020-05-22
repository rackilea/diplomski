class MyActor extends Actor {

    def receive = {
        case Start: {
            val f = lockActor ? LockRequestMessage
            f onSuccess {
                case LockApprovalMessage => {
                    //todo: do your thing
                }
            }
        }
    }

}