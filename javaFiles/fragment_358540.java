public String getpolicyNo(String initpolicyNo) {
    switch(initPolicyNo.charAt(0))
    {
       case 'B':
          System.out.println("Its building B");
          return initpolicyNo;
       case 'C':
          System.out.println("Its building C");
          return initpolicyNo;
       case 'L':
          System.out.println("Its building L");
          return initpolicyNo;
       case 'V':
          System.out.println("Its building V");
          return initpolicyNo;
    }

    throw new IllegalArgumentException();
}