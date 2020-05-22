char* ip_to_string(uint32_t ip)
{
    unsigned char bytes[4];
    bytes[0] = ip & 0xFF;
    bytes[1] = (ip >> 8) & 0xFF;
    bytes[2] = (ip >> 16) & 0xFF;
    bytes[3] = (ip >> 24) & 0xFF;

    char *ip_string;
    sprintf(ip_string, "%d.%d.%d.%d", bytes[0], bytes[1], bytes[2], bytes[3]);
    return ip_string;
}