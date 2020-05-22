Object[] elements = {"Apple","Orange","Grape","Mango","Banana"};

    Object obj = null;
    int elementsLength = elements.length;

    int i = 10;

    if (i < elementsLength) {
        obj = elements[i];
    } else {
        System.out.println("Oops!.. Out of index!");
    }

    if (obj != null) {
        System.out.println(obj);
    }