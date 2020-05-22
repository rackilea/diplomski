Socks.SocksClient.createConnection(options)
          .then(info => {
            const tlsSocket= tls.connect(
              {
                host: <java server ip>,
                port: 443,
                socket: info.socket
              },
              () => {
                tlsSocket.write('GET /users HTTP/1.1\r\nAuthorization: Basic <token>\r\nHost: <java server ip>:443\r\n\r\n');
              }
            );

            tlsSocket.on("data", function(data) {
              // do something with data
            });
          })
          .catch(err => {
            console.log(err);
          });