String result;
for (Future<String> fut : tasks) {
    String taskResult = fut.get();
    if (taskResult != null && !taskResult.isEmpty()) {
        result = taskResult;
        break;
    }
}