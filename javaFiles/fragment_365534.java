String fileName;
Scanner scanner = new Scanner (clientSocket.getInputStream());
while(scanner.hasNextLine())
{
    fileName = scanner.nextLine();
    break;
}
fileInputStream = new FileInputStream(fileName);
fileInputStream = new BufferedInputStream(fileInput);