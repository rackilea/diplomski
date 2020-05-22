public void mergeSort(File[] inFiles, File outFile, Comparator<String> comparator) throws IOException  {

      try {
         BufferedReader[] readers = new BufferedReader[inFiles.length];
         PrintWriter writer = new PrintWriter(outFile);
         TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(
               comparator);

         // read first line of each file. We don't check for EOF here, probably should
         for (int i = 0; i < inFiles.length; i++) {
            readers[i] = new BufferedReader(new FileReader(inFiles[i]));
            String line = readers[i].readLine();
            treeMap.put(line, Integer.valueOf(i));
         }

         while (!treeMap.isEmpty()) {
            Map.Entry<String, Integer> nextToGo = treeMap.pollFirstEntry();
            int fileIndex = nextToGo.getValue().intValue();
            writer.println(nextToGo.getKey());

            String line = readers[fileIndex].readLine();
            if (line != null)
               treeMap.put(line, Integer.valueOf(fileIndex));
         }
      }
      finally {
         // close everything here...
      }
   }