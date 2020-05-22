public static void main(String[] args) throws IOException {
        //counters
        int charsCount = 0;
        int wordsCount = 0;
        int linesCount = 0;

        Scanner in = null;
        File selectedFile = null;
        JFileChooser chooser = new JFileChooser();
        // choose file 
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            in = new Scanner(selectedFile);
        }

        while (in.hasNext()) {
            String tmpStr = in.nextLine();
            if (!tmpStr.equalsIgnoreCase("")) {
                String replaceAll = tmpStr.replaceAll("\\s+", "");
                charsCount += replaceAll.length();
                wordsCount += tmpStr.split(" ").length;
            }
            ++linesCount;
        }

        //display the count of characters, words, and lines
        System.out.println("# of chars: " + charsCount);
        System.out.println("# of words: " + wordsCount);
        System.out.println("# of lines: " + linesCount);

        in.close();
    }