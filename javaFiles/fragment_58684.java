while (firstFile.hasNext()) {
    firstFileList.add(firstFile.nextLine().trim());
}

while (secondFile.hasNext()) {
    secondFileList.add(secondFile.nextLine().trim());
}

try {
    for (String fileOne : firstFileList) {
        boolean value = secondFileList.contains(fileOne);
        if (value) {
            missingRecordsInFile2.add(fileOne);
            fWriteOne.write(fileOne);
            fWriteOne.write(System.getProperty("line.separator"));
        }
    }
} finally {
    fWriteOne.close();
}