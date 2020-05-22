public List<VehicleInformationBean> getAllVehiclesInTree(String response) {

    List<VehicleInformationBean> vehicleList = new ArrayList<VehicleInformationBean>();

    try {
        PersonInformationBean mPersonInformationBean;
        DatabaseHelper mDatabaseHelper = DatabaseHelper.getInstance(sContext);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = (ObjectNode) mapper.readTree(response);

        if ((root.get(ServiceConstant.ErrorCode).asInt()) != 0 || !root.has(ServiceConstant.Schedules)) {
            return vehicleList;
        }

        for(JsonNode element: root.get(ServiceConstant.Schedules)) {
            VehicleInformationBean lstVehicleInformation = new VehicleInformationBean();
            if (element.has(ServiceConstant.PersonID)) {
                String personId = element.get(ServiceConstant.PersonID).asText();
                mPersonInformationBean = mDatabaseHelper.getPersonDetailById(personId);
                lstVehicleInformation.setPersonID(personId);
                lstVehicleInformation.setName(mPersonInformationBean.getName());
                lstVehicleInformation.setPickupLocation(mPersonInformationBean.getPickupLocation());
                lstVehicleInformation.setDropLocation(mPersonInformationBean.getDropLocation());
            }
            lstVehicleInformation.setTripType(element.get(ServiceConstant.TripType).textValue());
            lstVehicleInformation.setStickerNumber(element.get(ServiceConstant.StickerNumber).textValue());
            lstVehicleInformation.setVehicleRegNo(element.get(ServiceConstant.VehicleRegNo).textValue());
            lstVehicleInformation.setExpectedStartDate(element.get(ServiceConstant.ExpectedStartDate).textValue());
            lstVehicleInformation.setActualStartDate(element.get(ServiceConstant.ActualStartDate).textValue());
            lstVehicleInformation.setActualEndDate(element.get(ServiceConstant.ActualEndDate).textValue());
            lstVehicleInformation.setPersonScheduledDate(element.get(ServiceConstant.PersonScheduledDate).textValue());
            lstVehicleInformation.setShift(element.get(ServiceConstant.Shift).textValue());
            if (element.has("PickupLocationCoord")) {
                JsonNode coords = element.get("PickupLocationCoord");
                if(coords.has(ServiceConstant.Latitude)) {
                    lstVehicleInformation.setLatitude(coords.get(ServiceConstant.Latitude).asDouble());
                }
                if(coords.has(ServiceConstant.Longitude)) {
                    lstVehicleInformation.setLongitude(coords.get(ServiceConstant.Longitude).asDouble());
                }
            } else if (element.has(ServiceConstant.ColdCall)) {
                lstVehicleInformation.setColdCall(element.get(ServiceConstant.ColdCall).textValue());
            }
        vehicleList.add(lstVehicleInformation);
        }

    } catch (Exception e) {
        // TODO doing something with exception or throw it if it can't be handled here
        e.printStackTrace();
    }
    return vehicleList;
}