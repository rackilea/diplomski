@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Config {

    // Other fields

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime fixedTime;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime submitDate;
}