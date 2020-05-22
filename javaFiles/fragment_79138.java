@AllArgsConstructor
@Getter
final class FieldDefinition<T> {

    private final String name;
    private final BiConsumer<MyDAO, T> setter;
}