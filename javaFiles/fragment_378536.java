1 import mpi.*;  
2  
3 
/**  
4  * Compile:impl specific.  
5  * Execute:impl specific.  
6  */  
7  
8 public class Send {  
9 
10     public static void main(String[] args) throws Exception { 
11 
12         MPI.Init(args); 
13 
14         int rank = MPI.COMM_WORLD.Rank() ; //The current process.
15         int size = MPI.COMM_WORLD.Size() ; //Total number of processes
16         int peer ; 
17 
18         int buffer [] = new int[10]; 
19         int len = 1 ;
20         int dataToBeSent = 99 ; 
21         int tag = 100 ; 
22 
23         if(rank == 0) { 
24 
25             buffer[0] = dataToBeSent ; 
26             peer = 1 ; 
27             MPI.COMM_WORLD.Send(buffer, 0, len, MPI.INT, peer, tag) ; 
28             System.out.println("process <"+rank+"> sent a msg to "+ 29                                "process <"+peer+">") ; 
30 
31         } else if(rank == 1) { 
32 
33             peer = 0 ; 
34             Status status = MPI.COMM_WORLD.Recv(buffer, 0, buffer.length, 35                                                 MPI.INT, peer, tag); 
36             System.out.println("process <"+rank+"> recv'ed a msg\n"+ 37                                "\tdata   <"+buffer[0]    +"> \n"+ 38                                "\tsource <"+status.source+"> \n"+ 39                                "\ttag    <"+status.tag   +"> \n"+ 40                                "\tcount  <"+status.count +">") ; 
41 
42         } 
43 
44         MPI.Finalize(); 
45 
46     }  
47 
48 }