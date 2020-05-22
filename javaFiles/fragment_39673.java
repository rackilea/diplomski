CompletableFuture<String> fut = new CompletableFuture<>();
    fut.complete("test1");
    System.out.println(fut.get()); // test1
    fut.complete("test2");
    System.out.println(fut.get()); // test1 , value ont overwritten

    fut.obtrudeValue("obtrudeValue");
    System.out.println(fut.get()); // obtrudeValue , overwrite the value even of completed future
    fut.obtrudeValue("newObtrudeValue");
    System.out.println(fut.get()); // newObtrudeValue , subsequent call overwrite the value

    fut.complete("test3");
    System.out.println(fut.get()); // newObtrudeValue , value not overwritten by calling complete