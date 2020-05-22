public static ArrayList<String> methodList = new ArrayList<String>();

@Override
public void onTestStart(ITestResult result) {   

      if ((chkAndAddArray(finalInstance))) {
        return;
    }   

    if (finalmethodname.equalsIgnoreCase(finalInstance.toString())) {
        parentTest= extent.createTest(finalmethodname);
    } else {
        parentTest= extent.createTest(finalInstance);
            }
        }

  boolean chkAndAddArray(String instance) {

    if (methodList.contains(instance)) {
        System.out.println(instance + " value is already present");
        return true;
    } else
        methodList.add(instance);
    System.out.println(instance + " value is not present & now, added");
    return false;
}





public void onTestSuccess(ITestResult tr) {

System.out.println("onTestSuccess");

    childTest = parentTest.createNode(tr.getName());
    childTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),  
   xtentColor.GREEN));
        e1.printStackTrace();
    }       
childTest.pass("Screenshot is below:", 
        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    } catch (IOException e1) {

        e1.printStackTrace();
        }
            }