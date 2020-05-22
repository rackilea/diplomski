String fileName;
Scanner scanner = new Scanner (clientSocket.getInputStream());
while(scanner.hasNextLine())
{
    fileName = scanner.nextLine();
    break;
}
fileInputStream = new FileInputStream(FILE_DIR + fileName);
fileInputStream = new BufferedInputStream(fileInput);