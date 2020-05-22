package commands

import org.crsh.cli.Command
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext

class custom {

    @Usage("Custom command")
    @Command
    def main(InvocationContext context) {
        return "Hello"
    }
}