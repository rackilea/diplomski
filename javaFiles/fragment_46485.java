@Override
public int compareTo(Process proc) {
  // this.arriveTime > proc.arriveTime --> >0
  // this.arriveTime < proc.arriveTime --> <0
  // this.arriveTime = proc.arriveTime --> 0
  return this.arriveTime - proc.arriveTime;
}