public class MyCustomCodeAction extends CustomCodeAction {
    public void install(InstallerProxy proxy) throws InstallException {
        // call the static function of your jar here
    }

    public void uninstall(UninstallerProxy Uproxy) throws InstallException {
        // you can do something here if you need (not must)
    }
}