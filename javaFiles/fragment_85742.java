interface CalendarRepository extends br.com.milo.repository.Repository<Calendar, Owner>{
    void save(Calendar calendar);
    void update(Calendar calendar);
    void delete(Integer id);
    ... (and all other methods you need)
}

@Repository
class CalendarRepositoryImpl implements CalendarRepository {
    ... (what you currently have in CalendarRepository)
}

class CalendarController {
    @Autowired
    CalendarRepository repository; // NOT CalendarRepositoryImpl
}