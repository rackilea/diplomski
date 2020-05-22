@Retention(value = RUNTIME)
@JacksonAnnotationsInside
@JsonFormat(shape = Shape.NUMBER,
            without = Feature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS)
public @interface JsonTimestamp {

}