for (i=0;i<stringLength;i++)
{
    recv(sock, (char*)&dataRecv, sizeof(dataRecv), 0) ;
    *data = dataRecv;
    memoireAllouee[i]=dataRecv;
}