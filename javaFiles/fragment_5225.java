char intBufferCoupReq[1024];
memset(intBufferCoupReq, '\0', sizeof(intBufferCoupReq));

int k = 0;
while ( 1 ) { 
    int nbytes = recv(sockfd, &intBufferCoupReq[k], 1, 0); 
    if ( nbytes == -1 ) { printf("recv error\n"); break; }
    if ( nbytes ==  0 ) { printf("recv done\n"); break; }
    k++;
}