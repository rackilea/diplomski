package demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/backoffice/tags")
public class SampleController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody List<Tag> tags) {
        System.out.println(tags);
    }
}