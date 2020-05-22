String cache = null;
        while (bufferedReader.ready()) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                readLine = readLine.replaceAll("\n", "");
                // we concat the last read line and the actual read one
                String concatLine = (cache != null ? cache : "") + readLine;
                String pre = "ORDER WILL SHIP ";
                String suf = " WORKING DAYS";
                // We check, if the concat line contains both: pre and suf
                if (concatLine.contains(pre) && concatLine.contains(suf)) {
                    String output = concatLine.substring(concatLine.indexOf(pre) + pre.length(),
                            concatLine.indexOf(suf));
                    // no need to remove linebreaks, because we're reading line by line
                    // Remove "_" in front and after the digit.
                    if (output.startsWith("_") && output.endsWith("_")) {
                        // Before (example): output = "_5_"
                        output = output.substring(1, output.length() - 1);
                        // After (example): output = "5"
                    }
                    int num = Integer.parseInt(output);
                    // break here too if you only have one digit in that input file.
                }
                // cached line is now the one we just read
                cache = readLine;
            } else {
                break;
            }
        } // And don't forget to close the Reader afterwards ;-)