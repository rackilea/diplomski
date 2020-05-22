final Graph g = TinkerGraphFactory.createTinkerGraph();
List<List> names = new ArrayList<>();
new GremlinPipeline<Vertex, ArrayList<Vertex>>(g).V().has("name", "marko").as("x").out().loop("x",
        new PipeFunction<LoopPipe.LoopBundle<Vertex>, Boolean>() {
            @Override
            public Boolean compute(LoopPipe.LoopBundle<Vertex> loopBundle) {
                return loopBundle.getLoops() < 100;
            }
        }, new PipeFunction<LoopPipe.LoopBundle<Vertex>, Boolean>() {
            @Override
            public Boolean compute(LoopPipe.LoopBundle<Vertex> loopBundle) {
                return "lop".equals(loopBundle.getObject().getProperty("name"));
            }
        }
).has("name", "lop").path(new PipeFunction<Vertex, String>() {
    @Override
    public String compute(final Vertex vertex) {
        return vertex.getProperty("name");
    }
}).fill(names);