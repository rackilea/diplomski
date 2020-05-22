@Override
public void snapshotState(FunctionSnapshotContext context) throws Exception {

    // called when it's time to save state

    myState.clear();

        // Update myState with current application state 

}

@Override
public void initializeState(FunctionInitializationContext context) throws Exception {

    // called when things start up, possibly recovering from an error

    descriptor = new MapStateDescriptor<>("state", Types.STRING, Types.POJO(BroadcastedStateType.class));

    myState = context.getKeyedStateStore().getMapState(descriptor);

    if (context.isRestored()) {

        // restore application state from myState  

    }       

}