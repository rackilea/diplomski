String key = String.valueOf(".*?\\b" + args[0].toLowerCase() + "\\b.*?");
         Pattern p = Pattern.compile(key);
         try (final BufferedReader br = Files.newBufferedReader(inputFile,
                    StandardCharsets.UTF_8)) {
                for (String line; (line = br.readLine()) != null;) {
                    // processing the line.
                    line = line.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "");
                    Matcher m = p.matcher(line);
                    if (m.find()) {
                        countstr++;
                    }           
                }
         }