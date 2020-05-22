// load the Launch module
loadModule("/System/Launch")

// some logic for loops/etc
for (i = 0; i < 30; i++) { 
    l = launch("name of launch configuration")    
    while (!prepare.isTerminated()) {
        // do something to wait like java.lang.Thread.sleep(1)
    }
}