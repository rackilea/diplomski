@RegisterForReflection
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrorMessage  {

    @JsonbProperty("status_message")
    private String statusMessage;

    @JsonbProperty("status_code")
    private Integer statusCode;

    @JsonbProperty("success")
    private boolean success = true;

    @JsonbTransient
    public boolean isValid() {

        return this.statusMessage != null && !this.statusMessage.isEmpty() && this.statusCode != null;
    }

}