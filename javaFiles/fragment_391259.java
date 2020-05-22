String[] files = {"test.pdf;3","test.pdf;1","differentTest.pdf;2","test.pdf;5","test.pdf;4", "test.excel;3","test.excel;1","test.excel;6","test.excel;5","test.excel;4"};

HashMap <String, Integer> newestFiles = new HashMap<String, Integer>(); 

for (String currentString : files) {
    String currentFileName = currentString.split(";")[0];
    Integer currentFileVersion = Integer.parseInt(currentString.split(";")[1]);

    if (newestFiles.containsKey(currentFileName)) {
        if (newestFiles.get(currentFileName) < currentFileVersion) {
            newestFiles.put(currentFileName, currentFileVersion);
        }
    }
    else {
        newestFiles.put(currentFileName, currentFileVersion);
    }
}

for (Entry<String, Integer> maxValue : newestFiles.entrySet()) {

    String result = new StringBuilder("Max version of file: ").append(maxValue.getKey()).append(" is: ").append( maxValue.getValue()).toString();
    System.out.println(result);
}