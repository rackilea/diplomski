public abstract class Command<RequestT, ResponseT> extends BasicCommand<RequestContext<RequestT>, ResponseT> {
    @Override
    public Collection<ResponseT> execute(RequestContext<RequestT> request) {
        ...
    }
}