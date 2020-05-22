package com.mycorp.lib.invoker;
public interface Logger {
    void out(Loggable message);
}

package com.mycorp.lib.invoker;
public interface Loggable {
    void setStatus(String status);
    String getStatus();
}

package com.mycorp.lib.invoker;
public class LoggableFactory {
    public static Loggable createDatabaseLogMessage() { return new DatabaseLogMessage(); }
    public static Loggable createWebserviceLogMessage() { return new WebserviceLogMessage(); }
}

package com.mycorp.lib.logger;
public class WebserviceLogMessage implements Logger {

    @Override public void out(Loggable message){
        Log.i("TAG", message.getStatus());
    }

    ...
}

package com.mycorp.lib.logger;
public class DatabaseLogMessage implements Logger {
    @Override public void out(Loggable message) {
        Log.i("JDBC",message.getStatus());
        otherFancyStuff(); // whatever ? :)
    }
}

package com.mycorp.lib.webservice;
public class JsonWebservice implements Webservice {
    Logger out;

    JsonWebservice(Logger out) { this.out = out; }

    @Override
    public void onErrorFound(String status) {
        Loggable message = LoggableFactory.createWebserviceLogMessage();
        message.setStatus(status);
        out.out(message);
    }

    ...
}