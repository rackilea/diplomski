int i = 0;
while(i < split.length){
    IMP[i] = Double.parseDouble(split[i]);
    i++;
}
double lastValue = IMP[i - 1];
while(i < years){
    IMP[i] = lastValue;
    i++;
}