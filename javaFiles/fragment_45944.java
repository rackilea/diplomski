@RequestMapping(value="/add", method=RequestMethod.POST, consumes="application/json")
public void addOrder(@RequestBody String json) {

    ObjectMapper mapper = new ObjectMapper();

    try {

        CustomerOrder order = mapper.readValue(json, CustomerOrder.class);
        System.out.println(order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName());

    } catch (JsonGenerationException e) {

        e.printStackTrace();

    } catch (JsonMappingException e) {

        e.printStackTrace();

    } catch (IOException e) {

        e.printStackTrace();

    }
}