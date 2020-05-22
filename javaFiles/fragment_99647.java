JSONObject holder = new JSONObject();

    //BrandInfo
    JSONObject brandInfo = new JSONObject();
    brandInfo.put("Model", "C500");
    brandInfo.put("ColorType", "Black");
    brandInfo.put("DatePurchased", "1990");


    holder.put("AutoMobileName", "Mercedes");
    holder.put("Engine", "V4");
    holder.put("BrandInfo", brandInfo);
    System.out.println(holder);