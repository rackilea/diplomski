package commands

import org.crsh.cli.Command
import org.crsh.cli.Usage
import org.crsh.command.InvocationContext
import org.springframework.beans.factory.BeanFactory
import com.alexbt.goodies.MyBean

class SayMessage {
    String message;
    SayMessage(){
        this.message = "Hello";
    }

    @Usage("Default command")
    @Command
    def main(InvocationContext context, @Usage("A Parameter") @Option(names=["p","param"]) String param) {
        BeanFactory beanFactory = (BeanFactory) context.getAttributes().get("spring.beanfactory");
        MyBean bean = beanFactory.getBean(MyBean.class);
        return message + " " + bean.getValue() + " " + param;
    }

    @Usage("Hi subcommand")
    @Command
    def hi(InvocationContext context, @Usage("A Parameter") @Option(names=["p","param"]) String param) {
        BeanFactory beanFactory = (BeanFactory) context.getAttributes().get("spring.beanfactory");
        MyBean bean = beanFactory.getBean(MyBean.class);
        return "Hi " + bean.getValue() + " " + param;
    }
}

> saymsg -p Johnny
> Hello my friend Johnny

> saymsg hi -p Johnny
> Hi my friend Johnny