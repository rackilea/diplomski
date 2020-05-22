public Map<String, String> populate(final List<Task> tasks) {
    Map<String, String> holder = new HashMap<>();
    if (tasks.size() == 0)
        return holder;
    int index = 0;
    int nl = System.getProperty("line.separator").getBytes(StandardCharsets.UTF_8).length;
    StringBuilder sb = new StringBuilder();
    sb.append(System.currentTimeMillis()).append(System.getProperty("line.separator"));
    int size = sb.toString().getBytes(StandardCharsets.UTF_8).length;
    for (Task task : tasks) {
        int ts = String.valueOf(task).getBytes(StandardCharsets.UTF_8).length;
        if (size + ts + nl > 60000) {
            String fileName = "tasks_info_" + index + ".txt";
            holder.put(fileName, sb.toString());
            index++;
            sb = new StringBuilder();
            sb.append(System.currentTimeMillis()).append(System.getProperty("line.separator"));
            size = sb.toString().getBytes(StandardCharsets.UTF_8).length;
        }
        sb.append(task).append(System.getProperty("line.separator"));
        size += ts + nl;
    }
    String fileName = "tasks_info_" + index + ".txt";
    holder.put(fileName, sb.toString());        
    return holder;
}