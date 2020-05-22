@Mapper
public interface LicenseMapper {
LicenseMapper MAPPING = Mappers.getMapper(LicenseMapper.class);

List<License> entityListToDaoList(List<com.integrator.vo.license.License> source);

License entityToDao(com.integrator.vo.license.License source);

List<CustomField> customFieldListToCustomFieldList(List<*your custom field path*CustomField> source);

@Mapping(expression = "java( String.valueOf(source.getValue()) )", target = "value")
CustomField customFieldToCustomField(*your custom field path*CustomField source);
}