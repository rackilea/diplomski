InputStream is
BufferedReader br
String fileContents
files.each { file ->
    is = file.getInputStream()
    br = new BufferedReader(new InputStreamReader(is))

    String line
    fileContents = ""
    while((line = br.readLine()) != null) {
        fileContents += line
    }
    println fileContents
    println "************************"
    br.close()
}