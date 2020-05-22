String response = "";
    for(int i = 0; i < Storage.size(); i++) {                       //Printing the Values for both Markers and Penalty
               response  += "Distance: " + HotelMarker.get(i) + " ";
                response += "Total Penalty: " + Penalty.get(i) + " ";
            }

return response ;