@Test       
 public void TEST3_MemberCreation() {     
homePage = login(admin);     
PolicyPage policyPage = homePage.NavigateToPolicyPage();     
policyPage.handleMultipleWindows("Policy");      
    policyPage.createPolicy( some requirements here);     
    policyPage.checkMessageByIdContains("Operation Apply executed Successfully", MESSAGE);     
            System.out.println("Policy Created succesfully");     
            }     
MembersPage membersPage = policyPage.clickMembersButton;(You have to handle the page navigation code inside this method and return MembersPage object)
membersPage.createMember(Data);     

}     

MembersPage clickMembersButton(){     
element.click();     
switchTo.window(newWindowHandle);     
return new MembersPage();     
}