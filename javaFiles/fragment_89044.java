JsonObject jo = parser.parse(inputJSON).getAsJsonObject();

 String resultCodeText = jo.get("response").getAsJsonObject().get("body").getAsJsonObject().get("resultInfo").getAsJsonObject().getAsJsonPrimitive("resultCode").getAsString();
 String resultCodeId = jo.get("response").getAsJsonObject().get("body").getAsJsonObject().get("resultInfo").getAsJsonObject().getAsJsonPrimitive("resultCodeId").getAsString();
 String resultStatus = jo.get("response").getAsJsonObject().get("body").getAsJsonObject().get("resultInfo").getAsJsonObject().getAsJsonPrimitive("resultStatus").getAsString();
 String checkoutUrl = jo.get("response").getAsJsonObject().get("body").getAsJsonObject().getAsJsonPrimitive("checkoutUrl").getAsString();