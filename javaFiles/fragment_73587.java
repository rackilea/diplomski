import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/things")
public class ThingController {

    @GetMapping
    public void filters(@RequestParam MultiValueMap<String, String> filters) {
        System.out.println("Filters:");
        filters.get("filter").forEach(System.out::println);
    }
}