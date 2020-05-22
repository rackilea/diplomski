// Don't need "implements VolleyJsonRespondsListener" because A already implemented it. So, just override onSuccessJson
public class B extends A {

    @Override
    public void onSuccessJson(String response, String requestName) {
        if("xyz".equals(requestName)) {
             // Child class expects "xyz". Handle it.
             CommonFunctions.showToastTest(context, "xyz toast");
        } else {
            // requestName not expected by Child class. Delegate to parent via super.onSuccessJson();
            super.onSuccessJson(response, requestName);
        } 
    }
}