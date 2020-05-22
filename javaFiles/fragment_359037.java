int[] bvalue = new int[1];

if (me == 0){ //this is the master process 
     bvalue[0] = 4;
}

//the master node will broadcast the value '4' and
//workers will block here waiting for the broadcast 
//to complete
MPI.COMM_WORLD.Bcast(bvalue, 0, 1, MPI.INT, 0);

//output the contents of bvalue
System.out.println("bvalue is " + bvalue[0]);