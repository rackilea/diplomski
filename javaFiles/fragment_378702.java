public class DossiersListPage extends
    AbstractListPage<DossierPage<DossiersListPage>> { // this is the tricky part

    @Override
    protected DossierPage<DossiersListPage> editPageHook() {
        return new DossierPage<>();
    }
    //...
}