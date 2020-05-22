//ManaCount.Java
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class ManaCount {
    private final int redManaCount;
    private final int whiteManaCount;

    private final int blueManaCount;
    private final int greenManaCount;

    private final int blackManaCount;
    private final int colorlessManaCount;

}