@JsonIgnore
public final StringBuffer url;
public final String ex;

public ErrorInfo(StringBuffer stringBuffer, Exception ex) {
    this.url = stringBuffer;
    this.ex = ex.getLocalizedMessage();
}