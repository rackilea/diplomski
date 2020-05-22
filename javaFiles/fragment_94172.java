@RequestMapping(value = "getNewCoordinatesForMarkers.htm", method = {RequestMethod.POST},produces = "application/json; charset=utf-8")
    public @ResponseBody  Marker getNewCoordinates(@RequestBody Marker json)throws Exception{

        JSONObject jsonObj = JSONObject.fromObject(json);

        ObjectMapper mapper = new ObjectMapper();

         Marker citizen = mapper.readValue(jsonObj.toString(), new TypeReference<Marker>(){});


        logger.info("Getting Markers");
        Marker citizenMarker = this.markerManager.getNextLocation(citizen);

        return citizenMarker;

    }