JSONArray arr = jobj.getJSONObject("UniversalWord").getJSONArray("UniversalWord");

        for (int i = 0; i < arr.length(); i++)
        {
            String uw_id = arr.getJSONObject(i).getString("uw_id");
            System.out.println(uw_id);
            String headWord = arr.getJSONObject(i).getJSONObject("HeadWord").getString("word");
            System.out.println(headWord);
            String nLDescription = arr.getJSONObject(i).getJSONObject("NLDescription").getJSONObject("Gloss").getJSONObject("feat").getString("val");
            System.out.println(nLDescription);
        }