public class Analysis {

    // execute show(Analysis.run()) on the Atlas shell
    public static Q run(){
        Q supertypeEdges = Common.universe().edgesTaggedWithAny(XCSG.Supertype);
        Q errors = supertypeEdges.reverse(Common.typeSelect("java.lang", "Error"));
        Q uncheckedExceptions = supertypeEdges.reverse(Common.typeSelect("java.lang", "RuntimeException"));
        Q typeOfEdges = Common.universe().edgesTaggedWithAny(XCSG.TypeOf);
        Q thrownUncheckedThrowables = typeOfEdges.predecessors(errors.union(uncheckedExceptions)).nodesTaggedWithAny(XCSG.ThrownValue);

        AtlasSet<Node> uncaughtThrownUncheckedThrowables = new AtlasHashSet<Node>();
        for(Node thrownUncheckedThrowable : thrownUncheckedThrowables.eval().nodes()){
            if(ThrowableAnalysis.findCatchForThrows(Common.toQ(thrownUncheckedThrowable)).eval().nodes().isEmpty()){
                uncaughtThrownUncheckedThrowables.add(thrownUncheckedThrowable);
            }
        }

        Q uncaughtThrownUncheckedThrowableMethods = Common.toQ(uncaughtThrownUncheckedThrowables).containers().nodesTaggedWithAny(XCSG.Method);
        Q callEdges = Common.universe().edgesTaggedWithAny(XCSG.Call);
        Q rootMethods = callEdges.reverse(uncaughtThrownUncheckedThrowableMethods).roots();
        Q callChainToUncaughtThrowables = callEdges.between(rootMethods, uncaughtThrownUncheckedThrowableMethods);
        return callChainToUncaughtThrowables.union(Common.toQ(uncaughtThrownUncheckedThrowables));
    }

}