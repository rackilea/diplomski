public String itemPickValue{get; set;}
public List<QC_Issue__c> issuesList{get; set;}
public List<QC_Issue__c> results; 

public List<QC_Issue__c> getIssues() {
    results = Database.query(
        'SELECT Component_Category__c, Issue_Name__c, Issue_Description__c, Severity_1_Criteria__c, Severity_2_Criteria__c, Severity_3_Criteria__c, File__c FROM QC_Issue__c Order By Component_Category__c, Issue_Name__c'
    );

    return results; 
}

public void getIssuesList() {
    if(itemPickValue.equals('All')) {
        issuesList = getIssues();
    } else {
        issuesList = Database.query('SELECT Component_Category__c, Issue_Name__c, Issue_Description__c, Severity_1_Criteria__c, Severity_2_Criteria__c, Severity_3_Criteria__c, File__c FROM QC_Issue__c WHERE Component_Category__c =: itemPickValue');
    }
}