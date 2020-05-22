while (...) {
        String lineNumber = bufferedReader.readLine();
        String time = bufferedReader.readLine();
        String text;
        while (!(text = bufferedReader.readLine()).equals(""))
            stringBuffer.append(text).append("\n");
    }