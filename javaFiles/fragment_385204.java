package crash.commands

import com.xyz.MyService
import org.crsh.cli.Command
import org.crsh.cli.Usage

@Usage("do something commands")
class foo extends SpringAwareCommand {
    @Command
    @Usage("bar")
    def String bar() {
        try {
            getBean(MyService.class).bar()
            return "did bar"
        } catch (Exception e) {
            return String.format("could not do bar: %s", e.toString())
        }
    }
}