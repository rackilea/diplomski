@Override
public void onFailure(Throwable caught) {
    try {
        throw caught;
    }
        catch (SessionExpiredException ex){
            onSessionExpired();
    }catch(Throwable e){
        MyCallback.this.onFailure(e);
    }
}