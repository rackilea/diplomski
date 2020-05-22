List<Future<FileReadings>> responses = new ArrayList<>();
      for (File file : x.getFileList()) {
           responses.add(executor.submit(new Process(file)));
      }
      // at this point all processes submitted but not finished.
      // need to check which is finished at intervarls
      while (responses.isEmpty() == false) {
          Thread.sleep(1000);  // allow some processing time for tasks
          // ListIterator allows removing items
          ListIterator<Future<FileReadings>> itr = responses.listIterator();
          while (itr.hasNext()) {
               Future<FileReadings> response = itr.next();
               // if task is complete, get it and remove from list
               if (response.isDone()) {
                   x.totalCharacterCount += response.get().characterCount;
                   x.totalLineCount += response.get().lineCount;
                   itr.remove();
               }
          }
      }