int start=-1;
for(int i =0; i<pixels.length; i++){
        System.out.println(pixels[i]);
        if(pixels[i] != 0 && start == -1) {
            start = i;
            System.out.println("start= " + start );
        } else if(pixels[i] == 0 && start != -1;){
            end = i;
            start = -1;
            System.out.println("end= " + end);
        }
    }