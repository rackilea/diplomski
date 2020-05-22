///...
          //// other code
          ///...      
          Map<String, Object > respMap = jsonToMap (result.toString());
          // don't need to convert from string to map again and again
          Map<String, Object > mainMap = (Map<String, Object >)respMap.get("main");
          Map<String, Object > windMap = (Map<String, Object >)respMap.get("wind");

          // fist get weather as list
          List<Map<String, Object >> weather = (List<Map<String, Object>>) (respMap.get("weather"));
            //...

          System.out.println("Wind Speed: " + windMap.get("speed")  );
          System.out.println("Wind Angle: " + windMap.get("deg")  );


          // weather as list
          System.out.println("Weather: "+ weather);

          // assuming weather contains at-least 1 element.
          Map<String, Object> weatherMap = weather.get(0);

          System.out.println("Weather as map: "+ weatherMap);