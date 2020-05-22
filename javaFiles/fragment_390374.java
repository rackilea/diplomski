BufferedReader br = new BufferedReader(new FileReader(file)); 
String line;
Boolean finishedFound = Boolean.FALSE;
StringBuilder contents = new StringBuilder();
while ((line = br.readLine()) != null) {
            if(line.startsWith("Finished !!!!")) {
                finishedFound = Boolean.TRUE;
                continue;
            }
            if(finishedFound) {
                contents.append(line+System.lineSeparator());
            }

        }
 // Here your code to write the contents to soot.txt