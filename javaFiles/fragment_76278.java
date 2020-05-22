public void configure() {
 from("switchyard://QueueConsumerService")
        .choice()
                .when(body(InventoryRequest.class))
                    .log("Received Inventory message : ${body}")
                    .to("some_endpoint")
                .when(body(AuditRequest.class))
                    .log("Audit request : ${body}");
                    .to("some_other_endpoint")
}