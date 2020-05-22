public class TsPayloadReaderFactoryProxy implements TsPayloadReader.Factory
    {

        private DefaultTsPayloadReaderFactory internal;

        public TsPayloadReaderFactoryProxy(int payloadReaderFactoryFlags, List<Format>  muxedCaptionFormats)
        {
            internal = new DefaultTsPayloadReaderFactory(payloadReaderFactoryFlags, muxedCaptionFormats);
        }

        @Override
        public SparseArray<TsPayloadReader> createInitialPayloadReaders ()
        {
            return internal.createInitialPayloadReaders();
        }

        @Override
        public TsPayloadReader createPayloadReader (
            int streamType, TsPayloadReader.EsInfo esInfo
        )
        {
            if ( streamType == TsExtractor.TS_STREAM_TYPE_ID3)
            {
                return new PesReader(new Id3ReaderProxy());
            }
            else
            {
                return internal.createPayloadReader(streamType, esInfo);
            }
        }

    }