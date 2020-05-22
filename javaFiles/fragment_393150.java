Object o = layer.get("data");

            if ( o instanceof JSONArray )
                solids = parseJSONArray( (JSONArray) o );
            else if ( o instanceof String 
                && "base64".equals( layer.get( "encoding" ) )
                && "zlib".equals( layer.get( "compression" ) )
            )
            {
                // base64 decode
                Decoder decoder = Base64.getDecoder();
                byte[] decodedBytes = decoder.decode((String) o);

                // zlib decompress
                Inflater decompresser = new Inflater();
                decompresser.setInput(decodedBytes);
                byte[] decompressedBytes = new byte[WIDTH * HEIGHT * 4];
                int resultLength = decompresser.inflate(decompressedBytes);
                decompresser.end();

                // convert `byte[N*4]` to `int[N]`
                int[] result = new int[WIDTH * HEIGHT];
                ByteBuffer bb = ByteBuffer.wrap(decompressedBytes);
                bb.order(ByteOrder.LITTLE_ENDIAN);
                bb.asIntBuffer().get(result);

                solids = parseIntArray( result );
            }
            else
                throw new RuntimeException( "Unimplemented data type: "
                    + o.getClass().getName() );