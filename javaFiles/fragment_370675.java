File searchFolder = new File("C:\\Users\\Name\\Desktop");
collectFiles(searchFolder, searchFolder.getName(), list);

for (String s : list) {
    System.out.println(s);
}