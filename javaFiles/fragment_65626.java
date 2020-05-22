public abstract class XListStore<M> extends ListStore<M> {

private String userText;

public XListStore(ModelKeyProvider<? super M> keyProvider) {
    super(keyProvider);
}

@Override
protected boolean isFilteredOut(M item) {
    return filter(item);
}

public abstract boolean filter(M item);

public String getUserText() {
    return userText;
}

public void setUserText(String userText) {
    this.userText = userText;
}
}