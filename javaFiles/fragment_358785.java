@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnyEntity {

    @EmbeddedId
    private BaseKey key;

}