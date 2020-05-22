@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor @AllArgsConstructor @RequiredArgsConstructor
public class UserPermission {
    @EmbeddedId
    private PK pk;

    @Embeddable
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor
    public static class PK implements Serializable {
        private String user;

        private String permission;
    }
}