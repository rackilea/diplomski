public class ForbiddenPackageNameAspectTest extends AbstractAspectJPolicyEnforcementTest {
    @Test
    public void testBadPackageName() throws Exception {
        assertThat(sourceFile(BadJavaClass.class),
            producesCompilationErrorWith(findAspect("ForbiddenPackageNameAspect")));
    }

    @Test
    public void testGoodPackageName() throws Exception {
        assertThat(sourceFile(ForbiddenPackageNameAspectTest.class),
                compilesWithoutWarningWith(findAspect("ForbiddenPackageNameAspect")));
    }
}