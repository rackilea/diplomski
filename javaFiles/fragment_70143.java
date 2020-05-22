public class FormInfo
{
   string Domain;
   string Name;
   string Category;
   // etc...

  public FormInfo(string domain, string name, string category)
  {
     Domain = domain;
     Name = name;
     Category = category;
     // etc...
  }
}


// Somewhere in your initialization code
public static FormInfo Info1 = new FormInfo("myDomain1", "myName1", "myCategory1");
public static FormInfo Info2 = new FormInfo("myDomain2", "myName2", "myCategory2");

You can still update one of your common merchants if you need to do something one-off:

// In your test case:
Info1.Category = "blah";
FormPage.FillForm(Info1);