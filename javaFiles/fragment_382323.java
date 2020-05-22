SyslogIF log = new UnixSocketSyslog() {
        @Override
        protected void write(int level, byte[] message) throws SyslogRuntimeException {
            if (this.fd == -1)
                connect();
            if (this.fd == -1)
                return;
            ByteBuffer byteBuffer = ByteBuffer.wrap(message);
            int ret = this.libraryInstance.write(this.fd,byteBuffer,message.length);
            if (ret < 0) {
                shutdown();
                connect();
                if (this.fd == -1)
                    return;
                ret = this.libraryInstance.write(this.fd,byteBuffer,message.length);
            }
        }
    };