if (pInValues.size() == 0)
    return null;

ArrayList<Value> outValues = new ArrayList<Value>();

for(Value value : pInValues) {
    outValues.add(0, new Value(String.valueOf(InetAddresses.isInetAddress(String.valueOf(value)))));
}

return outValues;