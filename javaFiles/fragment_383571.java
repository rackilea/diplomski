public static void main (String[] args)
{ 
    List<String> alist = Arrays.asList ("a","b","c");
    List<String> blist = Arrays.asList ("b","c","c","a");
    List<String> clist = Arrays.asList ("e","d","c","a");
    List<List<String>> llist1 = Arrays.asList (alist,blist);
    List<List<String>> llist2 = Arrays.asList (alist,clist);
    System.out.println ("has dups? " + hasduplicateList (llist1));
    System.out.println ("has dups? " + hasduplicateList (llist2));
}