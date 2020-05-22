String branchName="name";
    String branchId="bid";
    String sourceBranch="sb"
    String alias="ppp"

   String[] command = {"curl" "-k" "-i" "-X" POST "-H" "Content-Type: multipart/form-data" --cookie "rsession=your rsession" "Content-Type:application/json" --data{branchName+":"+branchId":"+sourceBranch":",+alias}};
    ProcessBuilder process = new ProcessBuilder(command); 
    Process p;
    try
    {
        p = process.start();
         BufferedReader reader =  new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ( (line = reader.readLine()) != null) {
                    builder.append(line);
                    builder.append(System.getProperty("line.separator"));
            }
            String result = builder.toString();
            System.out.print(result);

    }
    catch (IOException e)
    {   System.out.print("error");
        e.printStackTrace();
    }