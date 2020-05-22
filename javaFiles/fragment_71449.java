public class Parameter {

public Object Value;

public Parameter(String name, Object defaultValue, String units) {
    setValue(defaultValue);
    //set others
}

ParameterChangedEvent listener;
public void addListener(ParameterChangedEvent event){
    listener = event;
}

public void setValue(Object value) {
    Value = value;  

    listener.ValueChanged();
}