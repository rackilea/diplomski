public class PrsData {

  private Map<String, List<PrsCDData>> prsCDData;

  public PrsData() {
      this.prsCDData = MapUtils.lazyMap(new HashMap<String,List<Object>>(), new Factory() {

          public Object create() {
              return LazyList.decorate(new ArrayList<PrsCDData>(), 
                             FactoryUtils.instantiateFactory(PrsCDData.class));
          }

      });
  }

}