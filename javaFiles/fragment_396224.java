try {
            //Main Node
            JSONArray mainNode = new JSONArray(loadJSONFromAsset()); //UPDATED

        //There are 2 objects, so looping through each one
        for(int i=0;i<mainNode.length();i++){

            //Collect JSONObject in ith position
            JSONObject eachObject = mainNode.getJSONObject(i);

            //Assuming there's a TextView and refd. as tvZooLocation...
            tvZooLocation.setText(eachObject.getString("zooLocation"));
            tvAnimalName.setText(eachObject.getString("animalName"));

        }

        //Parsing Finished


    } catch (JSONException e) {
        e.printStackTrace();
    }