@JsonRootName("status")
class StatusDto {

    @JacksonXmlProperty(isAttribute = true)
    private Long id;

    @JacksonXmlText
    private String status;

    @JacksonXmlProperty(isAttribute = true)
    private Integer count;
}