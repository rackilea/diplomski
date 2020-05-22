public interface IBasePage {
  //... unimplemented base page methods
}

public class BasePageImpl implements IBasePage {
  public BasePageImpl(WebDriver webDriver) { //... }
  //... implemented base page methods
}

public class FastPage implements IBasePage {
  //... delegate all base page methods to the BasePageImpl
}

public class SlowPage extends SlowLoadableComponent implements IBasePage {
  //... delegate all base page methods to the BasePageImpl
}