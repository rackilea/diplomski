import java.util.concurrent.TimeUnit;

import play.*;
import play.mvc.*;
import play.mvc.Http.RequestHeader;

import static play.mvc.Results.*;
import play.libs.Akka;
import akka.actor.ActorSystem;
import akka.actor.ActorRef;
import akka.actor.UntypedActorFactory;
import akka.actor.UntypedActor;
import akka.actor.Props;
import akka.actor.ActorRefFactory;

import akka.util.*;
public class Global extends GlobalSettings {

    ActorRef tickActor;

    @Override
    public void onStart(Application app) {
        Logger.info("D");
        tickActor = Akka.system().actorOf((new Props().withCreator(new UntypedActorFactory() {
              public UntypedActor create() {
                    return new UntypedActor() {
                      public void onReceive(Object message) {
                        if (message.equals("Log")) {
                                 //Do something
                         // controllers.Application.log();
                        } else {
                          unhandled(message);
                        }
                      }
                    };
                  }
                })));
        Akka.system().scheduler().schedule(
                  Duration.create(0, TimeUnit.MILLISECONDS),
                  Duration.create(30, TimeUnit.MINUTES),
                  tickActor, 
                  "Log"
                );

    }



}