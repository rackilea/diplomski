@Test
public void testGUI_Automation() throws Exception {
    String VAR_1="30000";
    GUI_Login_MR_SIT();
}

public void GUI_Login_MR_SIT() throws Exception {
    selenium.open("/CSAlogin");
    selenium.type("//input[@id=\"username\"]", "Administrator");
    selenium.type("//input[@id=\"password\"]", "Ari_123");
    selenium.click("//img[@src=\"/csaweb/resources/images/buttons/bf_login.gif\"]");
    System.out.println("-----------GUI Login Successful-----------");
    }

}