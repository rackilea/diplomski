int i = 0;
      Integer[] counts = countStudents.values().stream().toArray(Integer[]::new);
      for (String courseKey : courses.keySet()) {
         printWriter.println(courseKey + "\t" + counts[i++]);
      }
      printWriter.close();
      writer.close();