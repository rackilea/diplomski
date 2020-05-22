StringBuilder sb = new StringBuilder();
     // loop over the lines to construct a stringbuilder 
     //containing the input
    while (sc.hasNextLine()) {
        String line = sc.nextLine();
        System.out.println(line);

        sb.append(line);

    }
       // then perform your processing 
    List<String> fieldNames = Arrays.asList("tto", "tCc", "tBcc", "customer_emailID", "Customer_name");
    try {
        JSONArray arr = new JSONArray(sb.toString());

        for (int i = 0; i < arr.length(); i++) {

            JSONObject obj = arr.getJSONObject(i);

            byte[] content = mask(obj, fieldNames, "777777").getBytes();
            fout.write(content);
            fout.write("\n".getBytes());

        }
    } catch (JSONException e) {
        // handle the exception
    }