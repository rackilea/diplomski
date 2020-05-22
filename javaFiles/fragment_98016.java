List<UserDeviceEntity> ude = userDeviceService.getAllUserByCompAndRole(ue.getCompanyId(), ue.getUserRoleId());
    System.out.println("roleid: "+ue.getUserRoleId());

    for(int i = 0; i < ude.size();i++){
        System.out.println("userid : "+ude.get(i).getUserId()); 


        List<UserDeviceEntity> uds = userDeviceService.getBikeId(ue.getUserId());
        System.out.println("compare userid: "+ue.getUserId());
        List<TBikeEntity> bikeServices = tbikeService.getAllLocation(ude.get(i).getUserId());
        System.out.println("size :"+bikeServices.size());

        if (ue.getUserId() == ude.get(i).getUserId()){
            List<TBikeEntity> bike = tbikeService.getAllLocation(ude.get(i).getBikeId());
            System.out.println("sizess bike 1 : "+bike.size());
            System.out.println("bikeidssssss : "+ude.get(i).getBikeId());   
        for (int j = 0; j < bike.size(); j++) {
            System.out.println("sizess : "+bike.size());
           YourObjectTypeHere obj1 = new YourObjectTypeHere(); obj1.put("bikeID",bike.get(j).getBikeId());
            obj1.put("imei",bike.get(j).getBikeImei());
            obj1.put("gpsTime",bike.get(j).getGpsLastUpdate());
            obj1.put("lo",bike.get(j).getBikeLongitude());
            obj1.put("la",bike.get(j).getBikeLatitude());
            obj1.put("gps_status",bike.get(j).getBikeGpsStatus());
            list.add(obj1);
        }
        obj.put("success", true);
        obj.put("data", list);

    }   

    }
    return obj;
}