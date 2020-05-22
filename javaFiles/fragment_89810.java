@SystemSetup(extension = IwacockpitsConstants.EXTENSIONNAME)
public class IwaCockpitsSystemSetup{

    @SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
    public void method_1(){

        //will be executed during the initialization process when the essential data for extension iwacockpits is created.

    }

    @SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.PROJECT)
    public void method_2(){

        //will be executed during the initialization process while creation of project data for extension iwacockpits.

    }

    @SystemSetup(process = SystemSetup.Process.UPDATE, type = SystemSetup.Type.ESSENTIAL)
    public void method_3(){

        //will be executed during the update process when the essential data for extension iwacockpits is created.

    }

    @SystemSetup(process = SystemSetup.Process.UPDATE, type = SystemSetup.Type.PROJECT)
    public void method_4){

        //will be executed during the initialization process when the project data for extension iwacockpits is created.

    }

    @SystemSetup(process = SystemSetup.Process.ALL, type = SystemSetup.Type.ALL)
    public void method_5){

        //will be executed during creation of project data or essential data in the same extension, in both init and update.

    }

}