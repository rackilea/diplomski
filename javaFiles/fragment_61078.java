public void splitThem(String s){
        // Split string to array
        String[] array = s.split(" ");
        System.out.println(Arrays.toString(array));
        // Parse 
        this.x1 = Integer.parseInt(array[3]); 
        this.y1 = Integer.parseInt(array[4]); 
        this.x2 = Integer.parseInt(array[5]); 
        this.y2 = Integer.parseInt(array[6]); 
        System.out.println(x1);
        System.out.println(y1);
        System.out.println(x2);
        System.out.println(y2);
    }