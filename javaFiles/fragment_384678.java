File fileToCopy = File(String pathname);
int sleepTime = 1000; // Sleep 1 second
while(!fileToCopy .canWrite()){
    // Cannot write to file, windows still working on it
    Sleep(sleepTime);
    sleepTime *= 2; // Multiply sleep time by 2 (not really exponential but will do the trick)
    if(sleepTime > 30000){ 
        // Set a maximum sleep time to ensure we are not sleeping forever :)
        sleepTime = 30000;
    }
}
// Here, we have access to the file, go process it
processFile(fileToCopy);