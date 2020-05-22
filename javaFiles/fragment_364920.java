JsonObject transactiondata = (JsonObject)Offer.get("transData");
JsonObject ticketdata = (JsonObject)transactiondata.get("tickets");
JsonObject offerData = (JsonObject)Offer.get("offerData");
JsonObject offerData1 = (JsonObject)offerData.get("offerconfig");

JsonArray jsonarr= (JsonArray)ticketdata.get("ticketDetails");

double ticketPrice = Double.parseDouble(jsonarr.get(0).getAsJsonObject().get("amount").getAsJsonObject().get("ticketPrice").getAsString());
System.out.println("ticketPrice:"+ticketPrice);