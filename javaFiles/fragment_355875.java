public class TestWidget extends Composite {
    //...

    HandlerRegistration handler;

    public TestWidget() {
        // ...

        handler = button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                // ...
                handler.removeHandler();                
            }
        });
    }

}