Iterator<DataOutputStream> it = clients.iterator();
while ((message = reader.readLine()) != null) { //reading    
    while (it.hasNext()) {
        try {
            DataOutputStream oss = it.next();
            oss.write(message);//writing
            oss.flush();
        }
        catch (Exception e) { }
     }
 }