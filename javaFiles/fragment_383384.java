package com.test;

import com.maxmind.geoip2.WebServiceClient;
import com.maxmind.geoip2.model.CountryResponse;

public class App {

   public static void main(String[] args) throws Exception {
      int userId = 0;
      String licenseKey = "key";

      WebServiceClient client = new WebServiceClient.Builder(userId, licenseKey).build();

      CountryResponse response = client.country();

      System.out.println(response.getCountry().getName());
   }

}