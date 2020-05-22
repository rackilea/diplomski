//Interface whose instances will bind strings to methods
interface ButtonClickHandler {
    void onClick();
}

class SomeClassYouNeed {
    //One of the methods that will be bound to "onButtonOneClick()"
    public void onButtonOneClick() {
        log.info("ButtonOneClick method is called");
    }

    public void onButtonTwoClick() {
        log.info("ButtonTwoClick method is called");
    }

    //Map that will hold your links
    private static Map<String, ButtonClickHandler> buttonActionMap;

    //Static constructor to initialize the map
    static {
        buttonActionMap = new Map<String, ButtonClickHandler>();
        buttonActionMap.put("onButtonOneClick()",new ButtonClickHandler() {
            @Override
            public void onClick() {
                onButtonOneClick();
            }
        });
        buttonActionMap.put("onButtonTwoClick()",new ButtonClickHandler() {
            @Override
            public void onClick() {
                onButtonTwoClick();
            }
        });
    }

    public void callByName(String methodName) {
        final ButtonClickHandler handler = buttonActionMap.get(methodName);
        if (handler == null) {
            throw new IllegalArgumentException("No handler found by name: "+methodName); 
        }
        handler.onClick();
    }
}