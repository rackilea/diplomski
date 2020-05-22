String pic = "THIS IS A VERY LONG STRING MORE THAN 20 CHARS";

ArrayList<String> strings = new ArrayList<String>();
int index = 0;

while (index < pic.length()) {
strings.add(pic.substring(index, Math.min(index + 20,pic.length())));
    index += 20; //split strings, add to arraylist
}

for(String s :strings){
    mBluetoothLeService.writeCharacteristic(characteristic, s); //write the string 
}