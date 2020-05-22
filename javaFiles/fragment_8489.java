%module sock          // Name of our module
%{
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>

/* Set some values in the sockaddr_in structure */
struct sockaddr *new_sockaddr_in(short family, unsigned long hostid, int port) {
        struct sockaddr_in *addr;
        addr = (struct sockaddr_in *) malloc(sizeof(struct sockaddr_in));
        bzero((char *) addr, sizeof(struct sockaddr_in));
        addr->sin_family = family;
        addr->sin_addr.s_addr = hostid;
        addr->sin_port = htons(port);
        return (struct sockaddr *) addr;
}
%}

// Add these constants
enum {AF_UNIX, AF_INET, SOCK_STREAM, SOCK_DGRAM, SOCK_RAW,
      IPPROTO_UDP, IPPROTO_TCP, INADDR_ANY};

#define  SIZEOF_SOCKADDR  sizeof(struct sockaddr)

// Wrap these functions
struct sockaddr *new_sockaddr_in(short family, unsigned long, int port);