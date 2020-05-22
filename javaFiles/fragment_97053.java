@Data
@Builder
public class StatusResponse {
    private LocalDate processedDate;

    @JsonAnyGetter
    private Map<Status, Integer> summary;
}