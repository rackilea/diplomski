try {
        // input the file content to the StringBuffer "input"
        BufferedReader file = new BufferedReader(new FileReader(f));
        StringBuffer inputBuffer = new StringBuffer();

        while ((line = file.readLine()) != null) {
            inputBuffer.append(line);
            inputBuffer.append('\n');
        }
        file.close();
        String inputStr = inputBuffer.toString();

        System.out.println(inputStr); // display the original file for debugging

            int wordIndex = inputStr.indexOf('the word')
            inputStr = inputStr.substring(0, wordIndex ) + "new string" + inputStr.substring(wordIndex , inputStr.length());             

        // display the new file for debugging
        System.out.println("----------------------------------\n" + inputStr);

        // write the updated content with the new string OVER the same file
        FileOutputStream fileOut = new FileOutputStream(f);
        fileOut.write(inputStr.getBytes());
        fileOut.close();

    } catch (Exception e) {
        System.out.println("Problem reading file.");
    }