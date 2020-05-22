while (isStreaming && !socket.isClosed() && socket.isConnected()) {
            try {
                if (bufferStack.empty()) continue;
                byte[] buffer = bufferStack.pop();
                if (buffer == null) continue;
                ... (Some headers needed for M-JPEG streaming. Read it on Wikipedia)
                output.write(buffer); // <-- will throw Exception if connection is broken
            } catch (Exception e) {
                e.printStackTrace();  // here you should also reset isStreaming
            }
        }