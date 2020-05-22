while ((line = reader.readLine()) != null)
    {
        String[] parts = line.split("\\((hex)\\)", 3);

        if (parts.length >= 2)
        {
            String key = parts[0].trim();
            String value = parts[1].trim();
            System.out.println("Key value pair is :"+key+"   "+value);
            map.put(key, value);
        } 
        else 
        {
            System.out.println("ignoring line: " + line);
        }
    }