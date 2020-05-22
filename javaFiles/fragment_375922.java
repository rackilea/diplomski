ProcessBuilder pb = new ProcessBuilder(["/usr/local/bin/mongod","run", "--config", "/usr/local/Cellar/mongodb/2.0.1-x86_64/mongod.conf"]); 

Process process = pb.start()

InputStream is = process.getInputStream();
InputStreamReader isr = new InputStreamReader(is);
BufferedReader br = new BufferedReader(isr);
String line;
while ((line = br.readLine()) != null) {
        System.out.println(line);
}


int exitValue = process.waitFor()
print exitValue