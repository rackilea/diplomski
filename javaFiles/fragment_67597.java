@Entity
@Table(name = "addresses")
public class Addresses {

  // home address -> In Belgium, so has to be between the default values:
  @ValidatePostalCode
  Integer belgianPostalCode;

  // vacation home in another country, let's say the PC's there are between
  // 12000 and 50000
  @ValidatePostalCode(minValue = 12000, maxValue = 50000)
  Integer foreignPostalCode;

}