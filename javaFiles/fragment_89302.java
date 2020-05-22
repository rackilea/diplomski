function findSortValueForProperty(property:String, priorityProperties:Array):int {
    var resultValue:int = 0;
    var index = 0;
    for each( var currentProperty:String in priorityProperties ) {
        if(property == currentProperty) {
            resultValue = priorityProperties.length - index;
            break;
        }
        ++index;
    }
    return resultValue;
}