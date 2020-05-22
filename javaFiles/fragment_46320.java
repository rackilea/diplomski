final Task a = new Task("A");
    final Task b = new Task("B");
    final Task c = new Task("C");
    final Task d = new Task("D");
    final Task e = new Task("E");
    final Task f = new Task("F");

    List<Task> tasks = asList(a, b, c, d, e, f);

    List<List<Task>> dependencies = asList(
        emptyList(), 
        emptyList(),
        asList(a),
        asList(a, b),
        asList(c, d),
        asList(e)
   );