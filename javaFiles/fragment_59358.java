public class CComponentV2Converter implements Converter<Object, List<CComponentV2>>
{
    static final long serialVersionUID = 0;

    @Override
    public List<CComponentV2> from(Object databaseObject)
    {
        var componentList = CObjectCaster.toMapList(databaseObject);
        List<CComponentV2> cComponentV2s = new ArrayList<>();
        componentList.forEach(e -> {
            CComponentV2 cComponentV2 = new CComponentV2();
            cComponentV2.setmShingleSize(CObjectCaster.toInteger(e.get("shingle_size")));
            cComponentV2s.add(cComponentV2);
        });
        return cComponentV2s;
    }
}