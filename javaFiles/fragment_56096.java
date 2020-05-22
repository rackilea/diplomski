public class ErrorHolder
{
    public String errorMessage;

    @JsonCreator
    public ErrorHolder(@JsonProperty("errorMessage") String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    // getters and setters
 }