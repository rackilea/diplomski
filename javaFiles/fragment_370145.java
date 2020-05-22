BasicCredentials credentials=new BasicCredentials(userName,passWord);
JiraClient jira=new JiraClient("https://myproject.info",credentials);

Issue.SearchResult sr = jira.searchIssues("Your project Name(in my case  TC)", 100);

     for (Issue i : sr.issues) {
           System.out.println(i.getSummary());
           System.out.println(i.getKey());
            etc ...

      }