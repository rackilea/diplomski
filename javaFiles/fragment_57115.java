@Component
@Scope(value = "step")
public class AbcItemProcessor implements ItemProcessor<AbcInfo, AbcInfo> {
    @Override
    public AbcInfo process(AbcInfo abcInfo) throws Exception {

        if (abcInfo.getRecordType().equals("H") || abcInfo.getRecordType().equals("T"))
            return null;//do your changes as you want to do with record based on condition
        else {
            abcInfo.setIdBatch(idBatch);
            abcInfo.setTmStamp(new Date(timeInMillis));
            return abcInfo;
        }
    }
}