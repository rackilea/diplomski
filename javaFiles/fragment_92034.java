BufferedReader br;
            try (PrintWriter writer = new PrintWriter(new BufferedWriter( new FileWriter("Member2_Temp.txt", true)))) {
               br = new BufferedReader(new FileReader(inFile));
               String line;

               while (null != (line = br.readLine())) {
                   if (newLine.equals(line)) {
                       line = line.replace(line, newLine);
                   }

                   // Always write the line, whether you changed it or not.
                   writer.println(line);
               }
                br.close();
                writer.flush();
                writer.close();