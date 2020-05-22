public class ManageHyperV {
    static final int RETURN_IMMEDIATE = 0x10;
    static final int FORWARD_ONLY = 0x20;     
    private static final int STOP = 0;
    private static final int START = 1;
    static IJIDispatch msvmServices = null;


    private static IJIDispatch createCOMServer(String namespace) { //root//virtualization
        JIComServer comServer;
        try {           
            JISystem.getLogger().setLevel(Level.WARNING);
            JISystem.setAutoRegisteration(true);

            JISession session = JISession.createSession(domainName,userName,password);
            session.useSessionSecurity(false);
            comServer = new JIComServer(valueOf("WbemScripting.SWbemLocator"),hostIP,session);

            IJIDispatch wbemLocator = (IJIDispatch) narrowObject(comServer.createInstance().queryInterface(IID));
            //parameters to connect to WbemScripting.SWbemLocator
            Object[] params = new Object[] {
                    new JIString(hostIP),//strServer
                    new JIString(namespace),//strNamespace
                    //                  new JIString("ROOT\\CIMV2"),
                    JIVariant.OPTIONAL_PARAM(),//strUser 
                    JIVariant.OPTIONAL_PARAM(),//strPassword 
                    JIVariant.OPTIONAL_PARAM(),//strLocale 
                    JIVariant.OPTIONAL_PARAM(),//strAuthority
                    new Integer(0),//iSecurityFlags 
                    JIVariant.OPTIONAL_PARAM()//objwbemNamedValueSet
            };
            JIVariant results[] = wbemLocator.callMethodA("ConnectServer", params);
            IJIDispatch wbemServices = (IJIDispatch) narrowObject(results[0].getObjectAsComObject());
            return wbemServices;
        } catch (JIException jie) {
            System.out.println(jie.getMessage());
            jie.printStackTrace();
        } catch (JIRuntimeException jire) {
            jire.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void getVMList() throws JIException {

            String temp = "select * from Msvm_ComputerSystem";          
            String[] arrQuery = new String[]{temp};

            for (int k=0;k<arrQuery.length;k++) {

                Object[] params = new Object[] {
                        new JIString(arrQuery[k]),
                        JIVariant.OPTIONAL_PARAM(),
                        new JIVariant(new Integer(RETURN_IMMEDIATE + FORWARD_ONLY))
                };

                JIVariant[] servicesSet = msvmServices.callMethodA("ExecQuery", params);
                iterateEnum(servicesSet);

            }       
    }

    private  static void iterateEnum(JIVariant[] servicesSet) {
        try {
            IJIDispatch wbemObjectSet = (IJIDispatch) narrowObject(servicesSet[0].getObjectAsComObject());
            JIVariant newEnumvariant = wbemObjectSet.get("_NewEnum");
            IJIComObject enumComObject = newEnumvariant.getObjectAsComObject();
            IJIEnumVariant enumVariant = (IJIEnumVariant) narrowObject(enumComObject.queryInterface(IJIEnumVariant.IID));
            List<Object[]> respArr = getEnumIterations(enumVariant);

            for (Object[] elements : respArr) {
                JIArray aJIArray = (JIArray) elements[0];
                JIVariant[] array = (JIVariant[]) aJIArray.getArrayInstance();

                for (JIVariant variant : array) {
                    IJIDispatch wbemObjectDispatch = (IJIDispatch) narrowObject(variant.getObjectAsComObject());

                    JIVariant[] v = wbemObjectDispatch.callMethodA("GetObjectText_", new Object[] {});
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println(v[0].getObjectAsString().getString());
                    System.out.println("----------------------------------------------------------------------");
                }
            }
        } catch (JIRuntimeException e) {
            e.printStackTrace();
        } catch (JIException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {    
        msvmServices = createCOMServer("root\\virtualization");
        getVMList();
    }

}

private static List<Object[]> getEnumIterations(IJIEnumVariant enumVariant) {
    List<Object[]> list = new ArrayList<Object[]>(); 
    int i=0;

    for (i=0;i<100;i++) {
        try {
            list.add(enumVariant.next(1));
        }catch (JIRuntimeException jre) {
            break;
        }
        catch (JIException jie) {
            break;              
        }
        catch (Exception e) {
            break;
        }
    }
    return list;
}