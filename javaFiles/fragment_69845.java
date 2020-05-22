@BeforeClass 
public static void initEvoSuiteFramework() { 
org.evosuite.runtime.RuntimeSettings.className = "com.ultimatix.gdpr.KeyClient"; 
org.evosuite.runtime.GuiSupport.initialize(); 
org.evosuite.runtime.RuntimeSettings.maxNumberOfThreads = 100; 
org.evosuite.runtime.RuntimeSettings.maxNumberOfIterationsPerLoop = 10000; 
org.evosuite.runtime.RuntimeSettings.mockSystemIn = true; 
org.evosuite.runtime.RuntimeSettings.sandboxMode = org.evosuite.runtime.sandbox.Sandbox.SandboxMode.OFF; 
org.evosuite.runtime.sandbox.Sandbox.initializeSecurityManagerForSUT(); 
org.evosuite.runtime.classhandling.JDKClassResetter.init();
setSystemProperties();
initializeClasses();
org.evosuite.runtime.Runtime.getInstance().resetRuntime();