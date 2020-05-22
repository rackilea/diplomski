public class Task {

Integer my_task_id;
String my_task_name;
Boolean my_task_is_complete;
Integer my_barcode;

public Task(){

}

public Task(Integer my_task_id, String my_task_name, Boolean my_task_is_complete, Integer my_barcode){
    super();
    this.my_task_id = my_task_id;
    this.my_task_name = my_task_name;
    this.my_task_is_complete = my_task_is_complete;
    this.my_barcode = my_barcode;
}

public Integer getMy_task_id() {
    return my_task_id;
}

public void setMy_task_id(Integer my_task_id) {
    this.my_task_id = my_task_id;
}

public String getMy_task_name() {
    return my_task_name;
}

public void setMy_task_name(String my_task_name) {
    this.my_task_name = my_task_name;
}

public Boolean getMy_task_is_complete() {
    return my_task_is_complete;
}

public void setMy_task_is_complete(Boolean my_task_is_complete) {
    this.my_task_is_complete = my_task_is_complete;
}

public Integer getMy_barcode() {
    return my_barcode;
}

public void setMy_barcode(Integer my_barcode) {
    this.my_barcode = my_barcode;
}