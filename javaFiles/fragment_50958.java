public static void main(String[] args) throws NoSuchFieldException, SecurityException, Exception {

    MyLogger logger = new MyLogger();
    System.out.println(logger.getLogFile());

    setFinal(logger, MyLogger.class.getDeclaredField("logFile"), new File("changed"));
    System.out.println(logger.getLogFile());
}

private static void setFinal(MyLogger logger, Field field, Object newValue) throws Exception {
    field.setAccessible(true);

    Field modifiersField = Field.class.getDeclaredField("modifiers");
    modifiersField.setAccessible(true);
    modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

    field.set(logger, newValue);
}