public QueueListener(String actorId,String qName){
        this._queueName = qName;
         if(!isActorinit){
                system=ActorSystem.create(actorId);

                isActorinit=true;
            }

          myActor=system.actorOf( Props.create(MessageExecutor.class, qName),qName);
    }