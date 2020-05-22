final String tempInputLine;

if((tempInputLine = this.in_.readLine()) == null ){
    //close
    this.terminateThread();
    return;
}
else{

    final String inputLine = tempInputLine.trim();
    if (ClientThread.numberPattern.matcher(inputLine).matches()){
        //...
    }
    //..
}