package weather.data;

//java object imports

import com.fasterxml.jackson.core.JsonParseException;
//import com.fasterxml.jackson.annotation.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.File;
import java.net.URL;
import java.io.IOException;

public class usertest {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException 
    {

        URL jsonUrl = new URL("http://api.openweathermap.org/data/2.5/forecast?lat=35&lon=139");

        ObjectMapper mapper = new ObjectMapper();

        Jweather jweather = mapper.readValue(jsonUrl, Jweather.class);

        for (int i=0; i<10; i++){   
        System.out.println(jweather.getList().get(i).getMain().getTemp());
        }
    }

}