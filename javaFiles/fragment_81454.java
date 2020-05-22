private static boolean flag = false;

@Given("^User Logs In$")
public void userLogsIn() {
    if(flag==false) {
        flag=true;
        //Place the code you want to run only for first time
    }
}