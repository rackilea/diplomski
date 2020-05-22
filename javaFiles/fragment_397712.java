import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class TestController {

  @PostMapping(value = "/")
  public ResponseEntity<CustomResponse<EntityExchange>> createEntity(
      @Valid @RequestBody EntityExchange entityExchange) {
    return null;
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<CustomResponse<EntityExchange>> updateEntity(
      @Validated({ExchangeEntityPutValidation.class}) @RequestBody EntityExchange entityExchange) {
    return null;
  }
}