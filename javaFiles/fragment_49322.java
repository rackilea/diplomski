String line;
            while ((line = reader.readLine()) != null) {

                if (HttpPatterns.CACHE_CONTROL.matches(line)) {
                    cacheControl = (CacheControl) HttpPatterns.RESPONSE_CODE.process(line);
                } else if (HttpPatterns.REQUEST_HEADER.matches(line)) {
                    requestHeader = (RequestHeader) HttpPatterns.REQUEST_HEADER.process(line);
                } else if (HttpPatterns.HOST.matches(line)) {
                    requestHost = (String) HttpPatterns.HOST.process(line);
                } else if (HttpPatterns.ACCEPT_ENCODING.matches(line)) {
                    continue;
                } else if (line.isEmpty()) {
                    break;
                }
                fullRequest += "\r\n" + line;
            }