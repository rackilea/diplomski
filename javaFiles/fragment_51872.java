ArrayList<Object> array = new ArrayList<Object>();
array.add(arrayList1);
array.add(arrayList2);
array.add(arrayList3);
array.add(arrayList4);

sendData = serialize(array);
DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
datagramSocket.send(sendPacket);