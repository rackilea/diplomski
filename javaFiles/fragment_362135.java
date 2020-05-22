if(this.packetHandlerRunnable.getNumAudioPackets() <= 0 
                && this.packetHandlerRunnable.getNumVideoPackets() <= 0 
                && this.packetHandlerRunnable.isDecoderComplete())
        {
            synchronized(packetHandlerRunnable)
            {
                this.packetHandlerRunnable.notify();
            }
        }