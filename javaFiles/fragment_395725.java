int totalBytesRead = 0;
int bytesRead;
while (totalBytesRead < file_size)
{
    if((bytesRead = recv(new_socket, buffer, buffer_len, 0)) == SOCKET_ERROR)
    {
        /* Handle failure. */
        break;
    }

    if (bytesRead != fwrite(buffer, 1, bytesRead, f))
    {
        /* Handle failure. */
        break;
    }

    totalBytesRead += file_size;
}