StringBuffer error = new StringBuffer();

BufferedReader reader = 
    new BufferedReader(new InputStreamReader(process.getErrorStream()));

while ((line = reader.readLine())!= null) {
        error.append(line);
}

System.out.println("Error is " + error.toString());