a = true;
b = true;

if(line.contains("conditionOne")){
    a = hasConditionOneEnabled;
    b = !a;
}
else if(line.contains("conditionTwo")){
    a = hasConditionTwoEnabled;
    b = !a;
}

if(a && b){        
    // do something 1
}
else if(b){
    // do something 2
}
else{
    // do something 3
}