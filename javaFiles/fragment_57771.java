@RestController
public class YourController {

    @PostMapping("/create-payment-intent")
    public String test(HttpServletRequest request, HttpServletResponse response) throws StripeException { 

            Gson gson = new Gson();
            resposne.setContentType("application/json");

            try {
                StringBuilder buffer = new StringBuilder();
                BufferedReader reader = request.getReader();
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                String dataBody = buffer.toString();

                CreatePaymentBody postBody = gson.fromJson(dataBody, 
                CreatePaymentBody.class);
                logger.info(" -------- <<<<<<>>>>>>---------- ---------- POSTBODY 
                -> {}", dataBody);
                PaymentIntentCreateParams createParams = new PaymentIntentCreateParams.Builder()
                        .setCurrency(postBody.getCurrency()).setAmount(new Long(calculateOrderAmount(postBody.getItems())))
                        .build();
                // Create a PaymentIntent with the order amount and currency
                PaymentIntent intent = PaymentIntent.create(createParams);
                // Send publishable key and PaymentIntent  details to client
                return gson.toJson(new CreatePaymentResponse("pk_test_fXXXXXXXXXXXX",
                        intent.getClientSecret()));
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                return "";
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }

    }       
}