import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EntityExchange {

  @NotBlank(message = "...", groups = ExchangeEntityPutValidation.class)
  private String id;

  @NotNull private String other;
}