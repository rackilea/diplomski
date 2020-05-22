String data ="-rw-rw-r--+ 1 aime1 svrtech 83338 Apr 2 10:26 sat.log -rw-rw-r--+ 1 aime1 svrtech 2435 Apr 2 10:48 MAT.log -rw-rw-r--+ 1 aime1 svrtech 3470 Apr 2 08:35 ant_build.log";

    String arr[]=data.split("(?<=.log )");
    for(String s:arr){
    System.out.println(s);
    }