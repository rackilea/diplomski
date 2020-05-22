@Entity
@Immutable
@AdminPresentationMergeOverrides({
        @AdminPresentationMergeOverride(name = "displayTemplate", mergeEntries = {
                @AdminPresentationMergeEntry(propertyType = PropertyType.AdminPresentation.FIELDTYPE, overrideValue = "BROADLEAF_ENUMERATION"),
                @AdminPresentationMergeEntry(propertyType = PropertyType.AdminPresentation.BROADLEAFENUMERATION, overrideValue = "com.community.core.domain.DisplayTemplateType"),
                @AdminPresentationMergeEntry(propertyType = PropertyType.AdminPresentation.REQUIREDOVERRIDE, overrideValue = "REQUIRED"),
                @AdminPresentationMergeEntry(propertyType = PropertyType.AdminPresentation.DEFAULTVALUE, overrideValue = "PLAN")
        })
})
public class CustomProduct extends ProductImpl {

    private static final long serialVersionUID = -5745207984235258075L;
}