List<Callable<FileReadings>> tasks = new Arraylist<>();
      for (File file : x.getFileList()) {
           tasks.add(new Process(file));
      }
      // submit all processes at once. they will be processed in parallel 
      // this call blocks until all tasks are finished
      List<Future<FileReadings>> responses = executor.invokeAll(tasks);
      // at this point all processes finished. all get() will return immediately
      for (Future<FileReadings> response : responses) {
           x.totalCharacterCount += response.get().characterCount;
           x.totalLineCount += response.get().lineCount;
      }