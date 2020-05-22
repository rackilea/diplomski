import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = YesNoAnswer.class, name = "YesNoAnswer"),
        @JsonSubTypes.Type(value = SelectListAnswer.class, name="SelectListAnswer"),
        @JsonSubTypes.Type(value = SelectAddressAnswer.class, name="SelectAddressAnswer")})
abstract class RequestFormAnswer {

    private String type;

}