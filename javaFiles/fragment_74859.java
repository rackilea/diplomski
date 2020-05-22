package pack;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Tab1Page implements Serializable{

/**
 * 
 */
private static final long serialVersionUID = 254415216070877770L;
// Constants
public final static String hashKey = "tab1PageTab";
public String actionString = "";

@PostConstruct
public void post(){
  Format formatter;
  Date date = new Date();

  // Time formate 01:12:53 AM
  formatter = new SimpleDateFormat("hh:mm:ss a");
  tabName = formatter.format(date);
    System.out.println("Tab1Page\t"+tabName+"\t@PostConstruct...");
}

@PreDestroy
public void destroy(){
  Format formatter;
  Date date = new Date();

  // Time formate 01:12:53 AM
  formatter = new SimpleDateFormat("hh:mm:ss a");
  tabName = formatter.format(date);
    System.out.println("Tab1Page\t"+tabName+"\t@PreDestroy...");
}


String tabName;

public String getTabName() {
    return this.getClass().getName().substring(this.getClass().getName().lastIndexOf("."))+"\t"+tabName;
}
public void setTabName(String tabName) {
    this.tabName = tabName;
}

public String getActionString() {
    return actionString;
}

public void setActionString(String actionString) {
    this.actionString = actionString;
}

}