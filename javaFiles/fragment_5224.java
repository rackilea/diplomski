char intBufferCoupReq[20];

int data = recv(sock, intBufferCoupReq, 80, 0);
printf("data recieved : %d\n",data);
if( data == -1){
    printf("Error while receiving Integer\n");
}