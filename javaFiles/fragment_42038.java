JSONArray servicesJSON = new JSONArray();
        ArrayList<Service> servicesArray = this.getServices();
        for(int i=0; i< servicesArray.size(); i++)
        {
            servicesJSON.add(servicesArray.get(i).toMap()); // use the toMap method here.
        }
        obj.put("services", servicesJSON);