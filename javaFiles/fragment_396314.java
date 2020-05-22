@RunWith(PowerMockRunner.class)
@PrepareForTest( { CustomPageLayoutUtils.class })
public class ModuleCloningServiceImplPowermockTest {

  private ModuleCloningServiceImpl moduleCloningService;

  private final CouponViewer moduleContent = new CouponViewer();

  private final PageLayout pageLayout = DomainObjectBuilder.newPageLayout().build();

  private Site site;

  private Product product;

  private CrudDao crudDao;

  private AuditLogger auditlogger;

  @Before
  public void init() {
    moduleCloningService = new ModuleCloningServiceImpl();
    crudDao = PowerMock.createMock(CrudDao.class);
    auditlogger = PowerMock.createMock(AuditLogger.class);
    ReflectionUtils.setByType(moduleCloningService, crudDao);
    ReflectionUtils.setByType(moduleCloningService, auditlogger);
    product = new Product(1L);
    site = DomainObjectBuilder.newSite().withId(1l).withProduct(product).build();

    PowerMock.mockStatic(CustomPageLayoutUtils.class);
  }  

  @Test
  public void copyModuleToPages_success_customLayoutTileCopy_default_tile() {


    ModuleType moduleType = getModuleType(ModuleTypeCode.COUPON, 2, 3);
    Module<CouponViewer> module = getModule(1L, moduleType);

    Page copyPage = getPage(1L, moduleType);
    PageLayout newPageLayout = DomainObjectBuilder.newPageLayout().build();
    newPageLayout.setCode(PageLayoutCode.CUSTOM);
    copyPage.setPageLayout(newPageLayout);
    List<Page> pages = Arrays.asList(copyPage);

    CustomPageLayoutUtils customPageLayoutUtils = PowerMock.createMock(CustomPageLayoutUtils.class);

    customPageLayoutUtils.tileNumberExistsInCustomPageLayout(9, null);
    expectLastCall().andReturn(false);
    customPageLayoutUtils.getPreferredOrDefaultTile(copyPage, moduleType);
    expectLastCall().andReturn(1);
    crudDao.save(EasyMock.anyObject());
    expectLastCall();
    auditlogger.audit(EasyMock.anyObject(AuditLogEntry.class));

    PowerMock.replayAll();
    OperationReport operationReport = moduleCloningService.copyModuleToPages(module, pages, 9);
    PowerMock.verifyAll();

    checkCopySuccessInPages(pages);
    for (Page page : pages) {
      for (ModulePage<? extends JaxbModule> modulePage : page.getModulePages()) {
        Assert.assertEquals(Integer.valueOf(1), modulePage.getTileNumber());
      }
    }
    Assert.assertTrue(operationReport.isSuccesful());
  }
}