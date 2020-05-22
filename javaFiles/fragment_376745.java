public class LightswitchTest { 
    @Test public void testLightswitch() {
        ActorSystem system = ActorSystem.create("lightswitchtest");//should make this static if you're going to test a lot of things, actor systems are a bit expensive
        new JavaTestKit(system) {{ //there's that static initializer again
            ActorRef lightswitch = system.actorOf(Props.create(Lightswitch.class)); //here is our lightswitch. It's an actor ref, a reference to an actor that will be created on 
                                                                                    //our behalf of type Lightswitch. We can't, as mentioned earlier, actually touch the instance 
                                                                                    //of Lightswitch, but we can send messages to it via this reference.

            lightswitch.tell(    //using the reference to our actor, tell it
                new PowerOn(),   //to "Power On," using our message type
                getRef());       //and giving it an actor to call back (in this case, the JavaTestKit itself)

            //because it is asynchronous, the tell will return immediately. Somewhere off in the distance, on another thread, our lightbulb is receiving its message

            expectMsgEquals(LightswitchState.on);   //we block until the lightbulb sends us back a message with its current state ("on.")
                                                     //If our actor is broken, this call will timeout and fail.

            lightswitch.tell(new PowerOff(), getRef());

            expectMsgEquals(LightswitchState.off);   

            system.stop(lightswitch); //switch works, kill the instance, leave the system up for further use
        }};
    }
}