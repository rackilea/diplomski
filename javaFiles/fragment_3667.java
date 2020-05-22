for(int i = 0; i < message.length(); i += k) 
{    
    result += message.substring(i, Math.min(i + k, message.length() - 1)) + " ";
    long n = Long.parseLong(message.substring(i, Math.min(i + k, message.length() - 1)), 2);
    m += n;
    System.out.print(n+" ");
}