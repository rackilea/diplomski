public class FooBarView implements FooDTO {
    private final FooDTO dto;

    //...

    // Maps field to JSON as 'fooBarColor'
    @JsonMap("fooBarColor")
    public String getColor() {
       return dto.getColor();
    }
}

@Entity
@Table(name="TBL_FOO")
public class FooEntity implements FooDTO {
    private final FooDTO dto;

    // ...

    @Column(name="DS_COLOR", length="255")
    public String getColor(){
        return super.getColor();
    }
}