public class YourPreferencesAction extends OpenPreferencesAction implements IIntroAction {

    @Override
    public void run(IIntroSite site, Properties params) {
        final IIntroPart introPart = PlatformUI.getWorkbench().getIntroManager().getIntro(); 
        PlatformUI.getWorkbench().getIntroManager().closeIntro(introPart);  
        run();
    }

}