restConfiguration()
.component("restlet")
.bindingMode(RestBindingMode.json)
.skipBindingOnErrorCode(false)
.port(port);    

rest("/v1")
    .post("/create")
        .route()
            .to("bean:myAssembler?method=assemble")
            .to("bean:myService?method=create");