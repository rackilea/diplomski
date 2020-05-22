@Service
public class DateServiceImpl implements DateService {
    @Override
    public Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }
}