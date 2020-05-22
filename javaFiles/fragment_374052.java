import java.io.FileReader; 
    import org.json.simple.JSONObject; 
    import org.json.simple.parser.*; 

        public class Example 
        { 
            public static void main(String[] args) throws Exception 
            { 
                // parsing file "JSONExample.json" 
                Object obj = new JSONParser().parse(new FileReader("/Users/dell/Documents/JSONExample.json"));          
                // typecasting obj to JSONObject 
                JSONObject jo = (JSONObject) obj; 

                // getting json filds
                String firstName = (String) jo.get("Address"); 
                String lastName = (String) jo.get("Area"); 
                String BookingDate = (String) jo.get("BookingDate"); 

                String BookingDetails = (String) jo.get("BookingDetails"); 
                String noOfBoxes = (String) jo.get("noOfBoxes"); 
                String createdAT = (String) jo.get("createdAT"); 
                String ModifiedAT = (String) jo.get("ModifiedAT"); 

                System.out.println(firstName); 
                System.out.println(lastName); 
                System.out.println(BookingDate); 
                System.out.println(BookingDetails); 
                System.out.println(noOfBoxes); 
                System.out.println(createdAT); 
                System.out.println(ModifiedAT); 

            } 
        } 

result of this file is 
Durga Nagar
West aerodrome
1970-01-01
[{"date": "2019-05-14","quantity": "55"},{"date": "2019-05-15","quantity": "58"},{"date": "2019-05-16","quantity": "50"}]
null
2019-03-29 07:48:07
2019-03-29 07:48:07