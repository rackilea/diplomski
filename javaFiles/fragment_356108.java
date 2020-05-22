SELECT Latitude, Longitude, StationName,
(
   3959 *
   acos(cos(radians(UserLatitude)) * 
   cos(radians(Latitude)) * 
   cos(radians(Longitude) - 
   radians(UserLongitude)) + 
   sin(radians(UserLatitude)) * 
   sin(radians(Latitude )))
) AS distance 
 FROM stations  
 ORDER BY distance ASC LIMIT 0,5;