home = System.getenv('Third_Party')

task env_read << {
    println "$System.env.HOME"
    //Other way of accessing the environment variable.
    println  System.getenv('Third_Party')
}