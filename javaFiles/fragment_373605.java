package net.earcam.example.servicecomponent;

public interface EchoService {

    String REPEAT_PARAMETER = "repeat";
    String FACTORY_DS = "echo.factory";
    String NAME_DS = "echo";

    String echo(String message);
}