public static ThisEscape newInstance(EventSource source){
   final ThisEscape instance = new ThisEscape();
   source.registerListener(new EventListener() {

        @Override
        public void onEvent(Event e) {
            instance.doSomething(e);
        }
    }
   return instance;
}