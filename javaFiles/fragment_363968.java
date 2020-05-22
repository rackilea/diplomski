public class MoveFileRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception{

        from("file://C:\\test")
          .choice()
          .when(simple("${in.header.CamelFileName} contains '.xlsx'"))
          .to("ftp://rob@10.171.16.100:21/test?password=rob")
          .otherwise()
          .to("log://org.apache.camel.howto?showAll=true&level=DEBUG");
    }


}