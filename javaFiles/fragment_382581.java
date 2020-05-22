public static void main(String[] args) {
    doProcess(processors.get("proc name"));
}
private static <T> void doProcess(Processor<T> processor) {
    T request = objectMapper.readValue(json, processor.getRequestType());
    processor.process(request);
}