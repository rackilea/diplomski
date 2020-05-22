2017-01-19 09:11:28,040 | ERROR | qtp762554626-172 | DefaultErrorHandler              | 75 - org.apache.camel.camel-core - 2.16.3 |  | Failed delivery for (MessageId: ID-Ralfs-MacBook-Pro-local-60691-1484813099793-0-2 on ExchangeId: ID-Ralfs-MacBook-Pro-local-60691-1484813099793-0-1). Exhausted after delivery attempt: 1 caught: com.fasterxml.jackson.core.JsonParseException: Unexpected character ('n' (code 110)): was expecting double-quote to start field name
 at [Source: java.io.ByteArrayInputStream@49828827; line: 33, column: 6]

Message History
---------------------------------------------------------------------------------------------------------------------------------------
RouteId              ProcessorId          Processor                                                                        Elapsed (ms)
[route1            ] [route1            ] [jetty:http://0.0.0.0:8282/some/path?httpMethodRestrict=PUT   ] [        15]
[route1            ] [restBinding1      ] [                                                                              ] [        12]

Exchange
---------------------------------------------------------------------------------------------------------------------------------------
Exchange[
    Id                  ID-Ralfs-MacBook-Pro-local-60691-1484813099793-0-1
    ExchangePattern     InOut

[..]

Stacktrace
---------------------------------------------------------------------------------------------------------------------------------------
com.fasterxml.jackson.core.JsonParseException: Unexpected character ('n' (code 110)): was expecting double-quote to start field name
 at [Source: java.io.ByteArrayInputStream@49828827; line: 33, column: 6]
    at com.fasterxml.jackson.core.JsonParser._constructError(JsonParser.java:1581)[55:com.fasterxml.jackson.core.jackson-core:2.6.3]
    at com.fasterxml.jackson.core.base.ParserMinimalBase._reportError(ParserMinimalBase.java:533)[55:com.fasterxml.jackson.core.jackson-core:2.6.3]
    at com.fasterxml.jackson.core.base.ParserMinimalBase._reportUnexpectedChar(ParserMinimalBase.java:462)[55:com.fasterxml.jackson.core.jackson-core:2.6.3]
[..]