Thread[] T = new Thread[3];
int n = 5;
for(i = 0; i < 3; i++)
    T[i] = new Thread();
Thread x = new Thread();
T[1] = T[1].start{
    sleep(500);
    println "testing";
}
x= x.start{
    n++;
}

x.join();
T[1].join();
println "DONE! " + n;