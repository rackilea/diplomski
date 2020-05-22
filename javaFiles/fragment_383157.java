start(){
    #run your process in background
    java -jar /root/BookkServer-0.0.1-jar-with-dependencies.jar &
    # write PID
    echo $! > program.pid  
}