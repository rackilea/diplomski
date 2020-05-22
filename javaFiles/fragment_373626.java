public int compareTo(TradeNode o) {  
    if (o.cstm.equals(this.cstm)) {  
        o.mon += this.mon;  
        return 0;  
    } else if (this.mon == o.mon) {  
        return this.cstm.compareTo(o.cstm);  
    } else {  
        //return (o.mon - this.mon);  
        return o.mon.compareTo(this.mon);  
    }  
}