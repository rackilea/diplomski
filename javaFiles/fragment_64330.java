public class XMLMaker {



    public DocumentBuilderFactory docDriverSetup;

    public DocumentBuilder driverSetup;

    public int connectedDevices = 0;

    Document doc;

    TransformerFactory transformerFactory = TransformerFactory.newInstance();

    Transformer transformer;

    public void setupDriverXMLFile(List <AppiumDriver<MobileElement>> driverList) {

        System.out.println("List size: "+ driverList.size());
        try {

            docDriverSetup = DocumentBuilderFactory.newInstance();

            driverSetup = docDriverSetup.newDocumentBuilder();

            doc = driverSetup.newDocument();

            transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://testng.org/testng-1.0.dtd");

            Element suiteElement = doc.createElement("suite");
            suiteElement.setAttribute("name", "All-tests");

            for(AppiumDriver<MobileElement> driver: driverList) {

                Element rootElement = doc.createElement("test");
                suiteElement.appendChild(rootElement);
                rootElement.setAttribute("name", (String) driver.getCapabilities().getCapability("deviceName"));

                Element deviceNameEle = doc.createElement("parameter");
                deviceNameEle.setAttribute("name", "deviceName");
                deviceNameEle.setAttribute("value", (String) driver.getCapabilities().getCapability("deviceName"));
                rootElement.appendChild(deviceNameEle);

                Element platformEle = doc.createElement("parameter");
                platformEle.setAttribute("name", "platform");
                platformEle.setAttribute("value", driver.getPlatformName()+"");
                rootElement.appendChild(platformEle);

                Element udidEle = doc.createElement("parameter");
                udidEle.setAttribute("name", "udid");
                udidEle.setAttribute("value", (String)driver.getCapabilities().getCapability("udid"));
                rootElement.appendChild(udidEle);

                Element urlPort = doc.createElement("parameter");
                urlPort.setAttribute("name", "URL");
                urlPort.setAttribute("value", (String)driver.getCapabilities().getCapability("appiumURL"));
                rootElement.appendChild(urlPort);

                Element devicePort = doc.createElement("parameter");

                if((driver.getPlatformName()+"").
                        toLowerCase().contains("android")) {
                        devicePort.setAttribute("name", "port");
                        devicePort.setAttribute("value", driver.getCapabilities().getCapability("systemPort")+"");

                }
                if ((driver.getPlatformName()+"").
                        toLowerCase().contains("ios")) {
                        devicePort.setAttribute("name", "port");
                        devicePort.setAttribute("value", (String)driver.getCapabilities().getCapability("wdaLocalPort"));
                }

                rootElement.appendChild(devicePort);

                Element packages = doc.createElement("packages");
                rootElement.appendChild(packages);
                Element packageName = doc.createElement("package");
                packageName.setAttribute("name", "BaseTest");
                packages.appendChild(packageName);


                connectedDevices++;
            }   
            suiteElement.setAttribute("parallel", "tests");
            suiteElement.setAttribute("thread-count", connectedDevices+"");
            doc.appendChild(suiteElement);

        } catch(ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } 

    }