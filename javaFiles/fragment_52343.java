List<String> failList = new ArrayList<>();

while (rs2.next()) {        //whatever that is (copied from OP)
    failList.add(rs2.getString("fail"));
}

double[] failsArray = new double[failList.size()]; //create an array with the size of the failList

for (int i = 0; i < failList.size(); ++i) { //iterate over the elements of the list
    failsArray[i] = Double.parseDouble(failList.get(i)); //store each element as a double in the array
}