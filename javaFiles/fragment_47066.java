public class HlsExtractorFactoryProxy implements HlsExtractorFactory
    {

        private DefaultHlsExtractorFactory internal = new DefaultHlsExtractorFactory();

        @Override
        public HlsExtractorFactory.Result createExtractor (
            Extractor previousExtractor,
            Uri uri,
            Format format,
            List<Format> muxedCaptionFormats,
            DrmInitData drmInitData,
            TimestampAdjuster timestampAdjuster,
            Map<String, List<String>> responseHeaders,
            ExtractorInput extractorInput
        )
            throws InterruptedException, IOException
        {
            HlsExtractorFactory.Result result = internal.createExtractor(
                previousExtractor,
                uri,
                format,
                muxedCaptionFormats,
                drmInitData,
                timestampAdjuster,
                responseHeaders,
                extractorInput
            );

            if ( result.extractor instanceof TsExtractor )
            {
                return createNewTsExtractor(
                    0,
                    true,
                    format,
                    muxedCaptionFormats,
                    timestampAdjuster
                );
            }

            return result;
        }

        private HlsExtractorFactory.Result createNewTsExtractor (
            @DefaultTsPayloadReaderFactory.Flags int userProvidedPayloadReaderFactoryFlags,
            boolean exposeCea608WhenMissingDeclarations,
            Format format,
            List<Format> muxedCaptionFormats,
            TimestampAdjuster timestampAdjuster
        )
        {
            @DefaultTsPayloadReaderFactory.Flags
            int payloadReaderFactoryFlags =
                DefaultTsPayloadReaderFactory.FLAG_IGNORE_SPLICE_INFO_STREAM
                | userProvidedPayloadReaderFactoryFlags;
            if ( muxedCaptionFormats != null )
            {
                // The playlist declares closed caption renditions, we should ignore descriptors.
                payloadReaderFactoryFlags |= DefaultTsPayloadReaderFactory.FLAG_OVERRIDE_CAPTION_DESCRIPTORS;
            }
            else if ( exposeCea608WhenMissingDeclarations )
            {
                // The playlist does not provide any closed caption information. We preemptively declare a
                // closed caption track on channel 0.
                muxedCaptionFormats =
                    Collections.singletonList(
                        Format.createTextSampleFormat(
                            null,
                            MimeTypes.APPLICATION_CEA608,
                            0,
                            null
                        ));
            }
            else
            {
                muxedCaptionFormats = Collections.emptyList();
            }
            String codecs = format.codecs;
            if ( !TextUtils.isEmpty(codecs) )
            {
                // Sometimes AAC and H264 streams are declared in TS chunks even though they don't really
                // exist. If we know from the codec attribute that they don't exist, then we can
                // explicitly ignore them even if they're declared.
                if ( !MimeTypes.AUDIO_AAC.equals(MimeTypes.getAudioMediaMimeType(codecs)) )
                {
                    payloadReaderFactoryFlags |= DefaultTsPayloadReaderFactory.FLAG_IGNORE_AAC_STREAM;
                }
                if ( !MimeTypes.VIDEO_H264.equals(MimeTypes.getVideoMediaMimeType(codecs)) )
                {
                    payloadReaderFactoryFlags |= DefaultTsPayloadReaderFactory.FLAG_IGNORE_H264_STREAM;
                }
            }

            TsExtractor extractor = new TsExtractor(
                TsExtractor.MODE_HLS,
                timestampAdjuster,
                new TsPayloadReaderFactoryProxy(payloadReaderFactoryFlags, muxedCaptionFormats)
            );

            return new HlsExtractorFactory.Result(
                extractor,
                false,
                true
            );
        }

    }