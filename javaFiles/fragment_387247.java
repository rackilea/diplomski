int n = 3;
    String[] name = new String[n];
    int[] num= new int[n];

    name[0] = "Example1";
    name[1] = "Example2";
    name[2] = "Example1";
    num[0] = 2;
    num[1] = 6;
    num[2] = 3;


    for (int i = 0; i < name.length; i++) {
        for (int j = i+1; j < name.length; j++) {
            if (name[i].equals(name[j])) {
                num[i] += num[j];
                num[j] = 0;
                name[j] = null;
            }
        }
    }


    for(int i=0;i<n;i++){
        if (name[i] != null) {
            System.out.println(name[i] + " " + num[i]);
        }
    }