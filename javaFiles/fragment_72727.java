import io.searchbox.action.AbstractAction;
import io.searchbox.action.GenericResultAbstractAction;

public class GetStartPage extends GenericResultAbstractAction {

    protected GetStartPage(Builder builder) {
        super(builder);
        setURI(buildURI());
    }

    protected String buildURI() {
        return super.buildURI() + "/?pretty";
    }

    @Override
    public String getRestMethodName() {
        return "GET";
    }

    public static class Builder extends AbstractAction.Builder<GetStartPage, Builder> {

        @Override
        public GetStartPage build() {
            return new GetStartPage(this);
        }
    }
}