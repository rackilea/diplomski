url <- "http://api.traveltimeapp.com/v4/time-map"

requestBodyK <- paste0('{ 
                      "departure_searches" : [ 
                      {"id" : "test", 
                      "coords": {"lat":', locationK[1], ', "lng":', locationK[2],' }, 
                      "transportation" : {"type" : "public_transport"} ,
                      "travel_time" : ', CommuteTimeK, ',
                      "departure_time" : "2018-06-27T13:00:00z"
                      } 
                      ] 
                      }')


requestBodyM <- paste0('{ 
                      "departure_searches" : [ 
                      {"id" : "test", 
                      "coords": {"lat":', locationM[1], ', "lng":', locationM[2],' }, 
                      "transportation" : {"type" : "driving"} ,
                      "travel_time" : ', CommuteTimeM, ',
                      "departure_time" : "2018-06-27T13:00:00z"
                      } 
                      ] 
                      }')