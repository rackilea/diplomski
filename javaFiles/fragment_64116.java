from("file:///tmp/camel/input")
            .routeId("Test Route")
            .to("file:///tmp/camel/test?noop=true")
            .onCompletion().onCompleteOnly()
            .log("Success for file: ${header.CamelFileName}")
            .end();

from("file:///tmp/camel/test?noop=true")
           .to("file:///tmp/camel/output")
           .to("file:///tmp/camel/output2");