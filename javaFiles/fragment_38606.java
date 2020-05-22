PipedInputStream pipedInput = new PipedInputStream();
PipedOutputStream pipedOutput = new PipedOutputStream(pipedInput);
new Thread(new ModelExportThread(model, pipedOutput)).start();
int bufferSize = 1024;
byte[] bytes = new byte[bufferSize];            
StringBuffer stringBuffer = new StringBuffer();
int bytesRead = pipedInput.read(bytes, 0, bufferSize);
boolean done = false;
String startRDF = "<rdf:RDF";
while (bytesRead > 0) {
    if (!done) {
        stringBuffer.append(new String(bytes, 0, bytesRead));
        int startIndex = stringBuffer.indexOf(startRDF);
        if ((startIndex >= 0)) {
            stringBuffer.insert(startIndex + startRDF.length(), " xml:base=\"" + namespace + "\"");
            outputStream.write(stringBuffer.toString().getBytes());
            stringBuffer.setLength(0);
            done = true;
        }
    } else {
        outputStream.write(bytes, 0, bytesRead);
    }
    bytesRead = pipedInput.read(bytes, 0, bufferSize);
}
outputStream.flush();