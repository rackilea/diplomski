// this.array = generator.apply((int) size);
Nodes$FixedNodeBuilder<T>(Nodes$ArrayNode<T>).<init>(long, IntFunction<T[]>) line: 646
Nodes$FixedNodeBuilder<T>.<init>(long, IntFunction<T[]>) line: 1199 
Nodes.builder(long, IntFunction<T[]>) line: 167
ReferencePipeline$3(ReferencePipeline<P_IN,P_OUT>).makeNodeBuilder(long, IntFunction<P_OUT[]>) line: 131
ReferencePipeline$3(AbstractPipeline<E_IN,E_OUT,S>).evaluate(Spliterator<P_IN>, boolean, IntFunction<E_OUT[]>) line: 543
ReferencePipeline$3(AbstractPipeline<E_IN,E_OUT,S>).evaluateToArrayNode(IntFunction<E_OUT[]>) line: 260
ReferencePipeline$3(ReferencePipeline<P_IN,P_OUT>).toArray(IntFunction<A[]>) line: 438
// Arrays.stream(new int[] { }).toArray(Integer[]::new);
Test.main(String[]) line: 15