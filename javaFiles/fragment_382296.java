Class<?> myClass = MessageReceiver.class;
StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

for (StackTraceElement element : stackTrace) {
    if (element.getClassName().equals(myClass.getCanonicalName())) {
        System.out.println("class found in stack trace");
        break;
    }
}