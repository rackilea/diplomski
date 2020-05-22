$ sudo dtrace -qn 'syscall::connect:entry { print(*(struct sockaddr_in6 *)copyin(arg1, arg2)) }' -c '/Library/Java/JavaVirtualMachines/jdk1.8.0_65.jdk/Contents/Home/bin/java Test'
[...]
struct sockaddr_in6 {
    __uint8_t sin6_len = 0
    sa_family_t sin6_family = 0x1e
    in_port_t sin6_port = 0x5000
    __uint32_t sin6_flowinfo = 0
    struct in6_addr sin6_addr = {
        union __u6_addr = {
            __uint8_t [16] __u6_addr8 = [ 0x2a, 0x2, 0x6, 0xb8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0x3 ]
            __uint16_t [8] __u6_addr16 = [ 0x22a, 0xb806, 0, 0, 0, 0, 0, 0x300 ]
            __uint32_t [4] __u6_addr32 = [ 0xb806022a, 0, 0, 0x3000000 ]
        }
    }
    __uint32_t sin6_scope_id = 0x8
}