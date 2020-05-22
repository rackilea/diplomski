public class HealthyUDXB_Order extends Application { 
private List<String> selected_items_gv= new ArrayList<String>(); 

public List<String> getSelected_items_gv() { 
return selected_items_gv; 
} 

public void setSelected_items_gv(List<String> selected_items_gv) { 
this.selected_items_gv.addAll(selected_items_gv); 
} 
}