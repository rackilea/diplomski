String arr[] = line.substring(2).trim().split(" ");

    float x = Float.parseFloat(arr[0]);
    float y = Float.parseFloat(arr[1]);
    float z = Float.parseFloat(arr[2]);
    m.vertices.add(new Vector3f(x,y,z));