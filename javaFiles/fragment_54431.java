@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CarDto.class, name = "car"),
        @JsonSubTypes.Type(value = BikeDto.class, name = "bike")
})
public class VehicleDto {
    private Long id;
    private String type;
    private Integer modelYear;
}

@Data
public class BikeDto extends VehicleDto {
    private String frameType;
}

@Data
public class CarDto extends VehicleDto {
    private Boolean isCabriolet;
}