/**
     * Removes all the commented part from the file content as well as returns a
     * file structure which have just lines with declaration syntax for eg.
     * Create Package packageName <- Stores all decalartion lines as separate
     * string in an array
     * 
     * @param file
     * @return file content
     * @throws IOException
     */
    private static List<String> filterContent(File file) throws IOException {

        StringBuilder withoutComment = new StringBuilder();
//      String declare = "";
//      String[] content;
//      List<String> readLines = FileUtils.readLines(file);
//
//      int size = readLines.size();
        System.out.println(file.getName() + "  at " + new Date());
        List<String> declareLines = new ArrayList<String>();
        // String line = null;
        int startComment = 0;
        int endComment = 0;
        Boolean check = false;
        Boolean isLineDeclaration = false;

        int j = 0;
        int i = 0;

        InputStream in = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        // Reading content line by line
        while ((line = reader.readLine()) != null) {
            // for (int i = 0; i < size; i++) {
            // line = readLines.get(i).toString();// storing current line data
            // If line contains */ that means comment is ending in this line,
            // making a note of the line number
            if (line.toString().contains("*/")) {
                endComment = i;
                // Removing the content before */ from the line
                int indexOf = line.indexOf("*/");
                line = line.replace(line.substring(0, indexOf + 2), "");
            }

            // If startComment is assigned fresh value and end comment hasn't,
            // that means the current line is part of the comment
            // Ignoring the line in this case and moving on to the next one
            if ((startComment > 0 && endComment == 0) || (endComment < startComment) || check)
                continue;

            // If line contains /* that means comment is starting in this line,
            // making a note of the line number
            if (line.contains("/*")) {
                startComment = i;
                // Removing the content after /* from the line
                int indexOf = line.indexOf("/*");
                line = line.replace(line.substring(indexOf), "");
                if (i == 0)
                    check = true; // means comment in the very first line
            }

            // If line contains -- that means single line comment is present in
            // this line,
            // removing the content after --
            if (line.contains("--")) {
                int indexOf = line.indexOf("--");
                line = line.replace(line.substring(indexOf), "");
            }
            // If line contains -- that means single line comment is present in
            // this line,
            // removing the content after --
            if (line.contains("#")) {
                int indexOf = line.indexOf("#");
                line = line.replace(line.substring(indexOf), "");
            }

            // At this point, all commented part is removed from the line, hence
            // appending it to the final content
            if (!line.isEmpty())
                withoutComment.append(line).append(" \n");
            // If line contains CREATE its a declaration line, holding it
            // separately in the array
            if (line.toUpperCase().contains(("CREATE"))) {
                // If next line does not contains Create and the current line is
                // the not the last line,
                // then considering two consecutive lines as declaration line,
                declareLines.add(line.toUpperCase());

                isLineDeclaration = true;
                j++;
            } else if (isLineDeclaration && !line.toUpperCase().contains(("CREATE"))) {
                // If next line does not contains Create and the current line is
                // the not the last line,
                // then considering two consecutive lines as declaration line,
                declareLines.set(j - 1, declareLines.get(j - 1) + " " + line.toUpperCase());
                isLineDeclaration = false;
            }
            i++;
        }

        reader.close();
        System.out.println("Read lines " + new Date());
//      List<String> list = new ArrayList<String>(Arrays.asList(declareLines));
        declareLines.removeAll(Collections.singleton(null));

//      content = list.toArray(new String[list.size() + 1]);

//      withoutComment = withoutComment..toUpperCase();
        declareLines.add(withoutComment.toString().toUpperCase());
        System.out.println("Retruning uncommented content " + new Date());
        return declareLines;
    }