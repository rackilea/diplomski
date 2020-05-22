public TaskSequenceComparator implements Comparator<Task> {

  public int compare(Task one, Task two) {
    return one.getSequence() - two.getSequence();
  }

}

...

List<Task> tasks = ...;
Collections.sort(tasks, new TaskSquenceComaprator());
// tasks is now sorted by sequence.