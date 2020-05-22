class Id3ReaderProxy implements ElementaryStreamReader
    {

        private Id3Reader internal = new Id3Reader();

        @Override
        public void seek ()
        {
            internal.seek();
        }

        @Override
        public void createTracks (
            ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator idGenerator
        )
        {
            internal.createTracks(extractorOutput, idGenerator);
        }

        @Override
        public void packetStarted ( long pesTimeUs, int flags )
        {
            internal.packetStarted(pesTimeUs, TsPayloadReader.FLAG_DATA_ALIGNMENT_INDICATOR);
        }

        @Override
        public void consume ( ParsableByteArray data ) throws ParserException
        {
            internal.consume(data);
        }

        @Override
        public void packetFinished ()
        {
            internal.packetFinished();
        }

    }