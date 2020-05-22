String[] command = {
    "pscp",
    "-q", // quiet, don't show statistics
    "-pw", // passw login with specified password
    "yourP4ssw0rd", // the user password
    "username@yourhost:file.csv", 
    "c:\\the\\destination\\of\\your\\file.csv"
};

// command == pscp -q -pw yourP4ssw0rd username@yourhost:file.csv c:\\the\\destination\\of\\your\\file.csv
Process p = Runtime.getRuntime().exec(command);
p.waitFor();

BufferedReader reader = 
     new BufferedReader(new InputStreamReader(p.getInputStream()));

String line = "";           
while ((line = reader.readLine())!= null) {
sb.append(line + "\n");
}

...