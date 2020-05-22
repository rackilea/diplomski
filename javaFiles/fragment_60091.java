IServiceLocator serviceLocator = PlatformUI.getWorkbench();
ICommandService commandService = (ICommandService) serviceLocator.getService(ICommandService.class);

try  { 
        Command command = commandService.getCommand("my_command_id");
        Map<String, String> map = new HashMap<String, String>();
        map.put("param_name", "param_value");
        /*more parameter's can be added to Map and passed*/
        command.executeWithChecks(new ExecutionEvent(null, map, null, null));

    } catch (ExecutionException e1) {

    } catch (NotDefinedException e2){

    } catch(NotEnabledException e3){

    } catch(NotHandledException e4){

    }