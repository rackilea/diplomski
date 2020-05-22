package x.SpringTodo_Auth.Controllers;

import x.SpringTodo_Auth.Models.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/validate")
public class ValidateController {

    @GetMapping
    public Object validate() {
        // Create and set the "Authorization" header before sending HTTP request
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + access_token);
        HttpEntity<String> entity = new HttpEntity<>("headers", headers);

        // Use the "RestTemplate" API provided by Spring to make the HTTP request
        RestTemplate restTemplate = new RestTemplate();
        Object user = restTemplate.exchange("https://myAuth0Username.auth0.com/userinfo", HttpMethod.POST, entity, User.class);
        return user;
    }

}