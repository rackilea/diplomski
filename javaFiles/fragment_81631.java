public class CommonAction implements ServletRequestAware, ModelDriven<CommonForm> {
  protected CommonForm commonForm = new CommonForm();
  @Override
  public CommonForm getModel() {
    return commonForm;
  }
}

public class ManageProfilesAction extends CommonAction {
  private ManageProfilesForm profForm = new ManageProfilesForm();
  @Override  
  public ManageProfilesForm getModel() {  
    return profForm;
  }
}