import org.jruby.Ruby;
import org.jruby.RubyModule;
import org.jruby.runtime.load.BasicLibraryService;

import java.io.IOException;

public class GreeterService implements BasicLibraryService {

    @Override
    public boolean basicLoad(final Ruby runtime) throws IOException {
        RubyModule greeter = runtime.defineModule(Greeter.class.getSimpleName());
        greeter.defineAnnotatedMethods(Greeter.class);

        return true;
    }

}