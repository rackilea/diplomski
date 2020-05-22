// make that bean get injected the instance of jackson's mapper and called either during the initialization or just after the spring's application context was loaded.
public afterStartup() {
    myJackSonMapper.addMixIn(Site.class, SiteInheritanceMixIn.class);
}
// considering here that SubSite is inheriting from Site 
@JsonSubTypes({
    @JsonSubTypes.Type(value = SubSite.class, name = "subSite")
})
public abstract class SiteInheritanceMixIn{

}