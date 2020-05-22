@Component
public class AccountPropertyEditor extends PropertyEditorSupport {
    @Inject
    private AccountDAO accountDao;
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(accountDao.getById(Integer.parseInt(text)));
    }

    @Override
    public String getAsText() {
        return String.valueOf(((Account) getValue()).getId());
    }
}