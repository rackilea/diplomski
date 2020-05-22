void client(const char* server_address, short server_port)
{
     int     sockfd;
     struct sockaddr_in servaddr;

     sockfd = socket(AF_INET, SOCK_STREAM, 0);

     memset(&servaddr, 0x00, sizeof(servaddr));
     servaddr.sin_family = AF_INET;
     servaddr.sin_port = htons(server_port);
     inet_pton(AF_INET, server_address, &servaddr.sin_addr);

     connect(sockfd, (struct sockaddr *) &servaddr, sizeof(servaddr));

     //from this point you can start write to the server and wait for its respose

     std::string buffer = "testquery";
     writen(sockfd, buffer.c_str(), buffer.length());

     char *ReadBuffer[512];
     while(1)
     {
         memset(ReadBuffer, 0x00, sizeof(ReadBuffer));
         int n = readn(sockfd, ReadBuffer, sizeof(ReadBuffer));
         if(n <= 0)
         {
             //or you dont have anything to read, or you have a problem
             break;
         }
         //this function does the hard job of knowing what to do with all these data
         processBuffer(ReadBuffer, n);
     }

 close(sockfd);

 }