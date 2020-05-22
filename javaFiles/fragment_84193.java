for x in range(0, 3):
    sock.sendall(b"{}\n".format(dict.get(x)))
    print(dict.get(x))
    print(sock.recv(1024))
sock.sendall("Bye\n")
print(sock.recv(1024))