public interface RequestGateway {

    String echo(String request);

}

....from(RequestGateway.class)
...