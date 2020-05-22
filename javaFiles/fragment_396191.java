URI uri = new URI(url.getProtocol(), 
                  null /*userInfo*/,
                  url.getHost(), 
                  url.getPort(), 
                  (url.getPath()==null)?null:URLDecoder.decode(url.getPath(), "UTF-8"),
                  (url.getQuery()==null)?null:URLDecoder.decode(url.getQuery(), "UTF-8"),
                  null /*fragment*/);