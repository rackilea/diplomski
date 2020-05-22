public static void everyOtherDestructive(Link<Integer> link){
    if(link == null) return; 
    if(link.next == null) return;
    link.next = link.next.next;
    everyOtherDestructive(link.next); 
}