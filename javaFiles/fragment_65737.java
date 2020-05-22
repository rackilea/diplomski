onException(IOException.class).to("direct:timeouts");

from("direct:start")
.setHeader(Exchange.HTTP_QUERY,simple("format=json&count=${in.headers.count}"))
.to("http4://www.host.com/someapi?httpClient.soTimeout=100")
.unmarshal().json(JsonLibrary.JACKSON,MyResponseType.class)
.to("bean:SomeBean?method=echo");

from("direct:timeouts").to("...");