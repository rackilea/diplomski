public class Application extends Controller {


public static Result generateReport()
{
    //create akka job

    //we should really create the actor with UUID name so that someone can't guess
    //and use the API to view the status of other peoples jobs, it be fairly easy
    //to guess as it goes $a,$b,$c etc...
   ActorRef myActor = Akka.system().actorOf(new Props(MyGeneratorMaster.class));

   System.out.println( myActor.path());
    myActor.tell(new ConfigMessage("blarg message"));

    return ok(generating.render("blarg","title",myActor.path().name()));
}

public static Result status(String uuid)
{
    uuid =  "akka://application/user/"+uuid;
    ActorRef myActor = Akka.system().actorFor(uuid);

    if(myActor.isTerminated())
    {
               return ok("Report Generated - All Actors Terminated") ;
    }
    else
    {

        return async(
                Akka.asPromise(ask(myActor,new StatusMessage(), 3000)).map(
                        new F.Function<Object,Result>() {
                            public Result apply(Object response) {

                                if(response instanceof ResultMessage)
                                {
                                    return ok(((ResultMessage) response).getResult());
                                }
                                return ok(response.toString());
                            }
                        }
                )
        );

    }
}