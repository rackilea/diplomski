onException(Exception.class).process(exchange -> logger.warn("Error")); //There is no need for end(), whole block is part of onException block

from("seda:rest_upload")
    .process(e -> {throw new RuntimeException();})
    .to("seda:parsed_csv");

from("seda:parsed_csv").to("log:parsed_csv");

from("timer:tmr?period=1000")
    .setBody(constant("mock"))
    .to("seda:rest_upload");