int offset= 0;
while (offset < stringLength)
{
    int count = recv(sock, &memoireAllouee[offset], stringLength-offset 0) ;
    if (count == 0)
        // premature EOS .. do something
        break;
    if (count == -1)
        // Error ... do something
        break;
    offset += count;
}