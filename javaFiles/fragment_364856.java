int value = htonl( 4 );
int reply = 0;

if( send( to_server_socket, &value, sizeof( value ), 0 ) != sizeof( value ) )
{
    printf( "socket write failed: %s", strerror( errno ) );
    exit( -1 );
}

if( recv( to_server_socket, &reply, sizeof( reply ), MSG_WAITALL ) != sizeof( reply ) )
{
    printf( "socket read failed: %s", streror( errno ) );
    exit( -1 )
}

printf( "got reply: %d\n", ntohl( reply ) );