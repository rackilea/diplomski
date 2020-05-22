package hello;

import javax.annotation.Resource;

import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Resource(name="camelTemplate")
    private ProducerTemplate template;

    @RequestMapping("/")
    String home() {
        System.out.println(template);
        return "Hello World!";
    }
}