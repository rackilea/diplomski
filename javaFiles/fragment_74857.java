package pack;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MyTabs{

@PostConstruct
public void init(){
    tabs = new ArrayList<MyTabObject>();
    tabs.add(new MyTabObject("tab1.xhtml", "tab1"));
    tabs.add(new MyTabObject("tab2.xhtml", "tab2"));
    tabs.add(new MyTabObject("tab3.xhtml", "tab3"));

}
String selectedTab="tab1";

public String getSelectedTab() {
    return selectedTab;
}

public void setSelectedTab(String selectedTab) {
    this.selectedTab = selectedTab;
}

public String switchPages(String selTab) {
    selectedTab = selTab;
    return "myTabs.xhtml";
}


List<MyTabObject> tabs;


public List<MyTabObject> getTabs() {
    return tabs;
}

public void setTabs(List<MyTabObject> tabs) {
    this.tabs = tabs;
}


}