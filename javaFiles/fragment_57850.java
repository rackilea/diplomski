String line;
while ((line = br.readLine()) != null) {
    selectionData[1] = line;
    System.out.println("Client Line2: " + selectionData[1]);
    sendData(selectionData);
}