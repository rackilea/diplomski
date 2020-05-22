for (final Method method : benchmarkMethods) {
    ...
    MeasureAndRecord(name, new IFunc() {
        @Override
        public Object onEvent() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            return method.invoke(set, (Object[]) null);
        }
    });

}