String s = " " +"\n";
if(this.Time == 0){
    s += "Random Number: " + this.numbr+ "\n";
}
else if(this.numbr == 0){ // <-- note ==
    s += "Random Time: " + this.Time+ "\n";
}
return s;