@Before
public void setUp() {
    org.springframework.test.util
       .ReflectionTestUtils.setField(
           theGetSkillListServiceCustomizeInstance,
           "searchSite",
           "valueToSet");
}