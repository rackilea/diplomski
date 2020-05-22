enum BoundProperty {
#foreach ($field in ${fields})
    ${field.toUpperCase()} #if( $foreach.hasNext ), #end
#end
}

#foreach ($field in ${fields})
    public ${field.type} get${field.name.substring(0,1).toUpperCase()}${field.name.substring(1)}(${field.type} newValue) {
        Type oldValue = fieldName;
        fieldName = newValue;
        firePropertyChange(BoundProperty.${field.name.toUpperCase()}, oldValue, newValue);       
    }
#end