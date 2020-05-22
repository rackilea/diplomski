@Override
public Page onRuntimeException(Page page, RuntimeException e) {     
    if(e instanceof InvalidUrlException) {
        return new HomePage();
    } else {
        return super.onRuntimeException(page, e);
    }
}