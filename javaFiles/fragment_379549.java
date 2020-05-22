while(x != 0) {
    // check odd-even first
    if (x % 2 == 0) {
        even = even + 1 ;
    }else{
        odd = odd + 1 ;
    }
    // then read next int
    x = IO.readInt();
}