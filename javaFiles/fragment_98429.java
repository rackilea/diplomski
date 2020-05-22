import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public ResponseEntity<String> myPostProcessingIngredientsMethod(..put args here...) {
  ... do something ...
  return new ResponseEntity<>("/recipies/edit?id=1", HttpStatus.OK));
}