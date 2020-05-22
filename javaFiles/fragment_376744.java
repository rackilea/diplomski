public class Lightswitch extends AbstractFSM<LightswitchState, NoDataItsJustALightswitch> {
    {  //static initializer
        startWith(off, new NoDataItsJustALightswitch()); //okay, we're saying that when a new Lightswitch is born, it'll be in the off state and have a new NoDataItsJustALightswitch() object as data

        //our first FSM definition
        when(off,                                //when in off,
            matchEvent(PowerOn.class,            //if we receive a PowerOn message,
                NoDataItsJustALightswitch.class, //and have data of this type,
                (powerOn, noData) ->             //we'll handle it using this function:
                    goTo(on)                     //go to the on state,
                        .replying(on);           //and reply to the sender that we went to the on state
            )
        );

        //our second FSM definition
        when(on, 
            matchEvent(PowerOff.class, 
                NoDataItsJustALightswitch.class, 
                (powerOn, noData) -> {
                    goTo(off)
                        .replying(off);
                    //here you could use multiline functions,
                    //and use the contents of the event (powerOn) or data (noData) to make decisions, alter content of the state, etc.
                }
            )
        );

        initialize(); //boilerplate
    }
}