public class MessagePresenterCreator implements IPresenterFactory{
    private final Map<Class<? extends Message>, Class<? extends MessagePresenter> mapping;
    public MessagePresenterCreator(Map<Class<? extends Message>, Class<? extends MessagePresenter> mapping) {
         this.mapping = mapping;
    }

    @Override
    public MessagePresenter createPresenter(Message m) {
       Class<? extends MessagePresenter> clazz = mapping.get(m);
       if (clazz == null) {
           throw new UnsupportedOperationException();
       }
       return clazz.newInstance();
    }
}