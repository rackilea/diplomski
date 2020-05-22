GplaySearch googlePlayInstance = new GplaySearch();

DetailsResponse response = googlePlayInstance.getDetailResponse("user@gmail.com",
        "password", "com.facebook.katana");

AppDetails appDetails = response.getDocV2().getDetails().getAppDetails();

System.out.println("version name : " + appDetails.getVersionString());
System.out.println("version code : " + appDetails.getVersionCode());