try{
   exec1();
   exec2(); // if exec1 fails,  it is not executed
}catch(){}

try{
   exec1();
}catch(){}
try{
   exec2(); // if exec1 fails,  it is  executed
}catch(){}