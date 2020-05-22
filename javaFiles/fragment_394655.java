@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type")
@JsonSubTypes({
    @Type(value = MVDImpl.class, name = "mvdimpl") })
interface MetricValueDescriptor
{
   ...
}