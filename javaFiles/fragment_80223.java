while (!handshakeComplete) {
            int b = input.read();

            if (b == -1)
                throw new WebSocketException ("Connected closed.");                

            if (pos == buffer.length)
                throw new WebSocketException ("Invalid handshake.");

            buffer[pos] = (byte) b; // THIS LINE CAUSES THE EXCEPTION
            pos += 1;

            if (buffer[pos - 1] == 0x0A && buffer[pos - 2] == 0x0D) {
                String line = new String(buffer, "UTF-8");
                if (line.trim().equals("")) {
                    handshakeComplete = true;
                } else {
                    handshakeLines.add(line.trim());
                }

                buffer = new byte[len];
                pos = 0;
            }
        }