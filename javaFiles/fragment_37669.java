from("direct:csvprocessor")
.pollEnrich("file:src/main/resources/?fileName=sample-data.csv&noop=true&idempotent=false")
.unmarshal(csv)
.to("bean:myCsvHandler?method=doHandleCsvData")
.setBody(constant("ok"))
.setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200));