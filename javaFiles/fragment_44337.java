class Handlers {
    <R extends Request, T extends Response> Handler<R, T> handlerForCriteria(Criteria criteria) {
        Handler<?, ?> handler = someStrategryThatIsUntyped();
        return (Handler<R, T>)handler; // just cast
    }
}