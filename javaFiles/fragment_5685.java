XScriptProviderSupplier xScriptPS = (XScriptProviderSupplier) UnoRuntime.queryInterface(XScriptProviderSupplier.class, xComponent);
XScriptProvider xScriptProvider = xScriptPS.getScriptProvider(); 
XScript xScript = xScriptProvider.getScript("vnd.sun.star.script:"+macroName); 

short[][] aOutParamIndex = new short[1][1];
Object[][] aOutParam = new Object[1][1];

Object[] aParams = new String[2];
aParams[0] = myFirstParameterName;
aParams[1] = mySecondParameterName;
@SuppressWarnings("unused")
Object result = xScript.invoke(aParams, aOutParamIndex, aOutParam);
System.out.println("xScript invoke macro " + macroName);