//The class with the web method
@Component
@Qualifier("myFacade")
@Service
public class MyFacade implements IMyFacade {

    /* the web method */ 
    findByYearMonth(@XmlJavaTypeAdapter(type = YearMonth.class, value = YearMonthAdapter.class) YearMonth yearMonth) throws MyException {
        // Break point should now show yearMonth = "2013-05"
    }
}