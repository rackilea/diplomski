public void fileDecode()
    {
        JSONParser parser = new JSONParser();

        try
        {
            FileReader file = new FileReader("C:\\JSONData\\test.json");
            Object obj = parser.parse(file);
            JSONObject jsonObject = (JSONObject)obj;
            JSONObject metrics = (JSONObject)jsonObject.get("metrics");
            JSONObject steps = (JSONObject)metrics.get("steps");
            JSONArray values = (JSONArray)steps.get("values");

            Iterator<Integer> iterator = values.iterator();
            while (iterator.hasNext())
            {
                System.out.println(iterator.next());
            }
            System.out.println(steps.get("min"));
            System.out.println(metrics.get("steps"));
            System.out.println(jsonObject.get("metrics"));

            file.close();
        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

    }