if(file.exists()) {
            Object obj = parser.parse(new FileReader("temp.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray array = (JSONArray) jsonObject.get("Clienti");
            PrintWriter write = new PrintWriter(new FileWriter(file));
            Iterator<JSONObject> iterator = array.iterator();
            while(iterator.hasNext()) {
                JSONObject it = iterator.next();
                data = (JSONObject) it; 
                System.out.println("Data" + data);
                arr.add(data);
                }
            arr.add(inner);
            System.out.println(arr);
            outer.put("Clienti", arr);
            System.out.println("Dati: " + outer);
            write.write(outer.toString());
            write.flush();
            write.close();
    }