SSOuser ouser = getFormatedResponseData(result.toString());
String finalValues = "";                                    
finalValues = finalValues + "\n" + "fname= " + ouser.firstname;
finalValues = finalValues + "\n" + "lastname= " + ouser.lastname;
finalValues = finalValues + "\n" + "abono= " + ouser.abono;
finalValues = finalValues + "\n" + "hash= " + ouser.hash;
finalValues = finalValues + "\n" + "role= " + ouser.role;
finalValues = finalValues + "\n" + "sso_user_id= " + ouser.sso_user_id;
finalValues = finalValues + "\n" + "token= " + ouser.token;
finalValues = finalValues + "\n" + "login= " + ouser.login;
finalValues = finalValues + "\n" + "error= " + ouser.error;
// finalValues=finalValues+
// "\n"+"cookie= " + output.cookie;
final String val = finalValues;

runOnUiThread(new Runnable() {
    public void run() {
    txtValues.setText(val);}});