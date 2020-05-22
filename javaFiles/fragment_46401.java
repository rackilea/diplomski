(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})  -> matches the IP address
(\\[.*\])                                    -> matches the date and time
(?:.*?)                                      -> matches the bare minimum number of
                                                characters between surrounding patterns
                                                groups
(\".+?\")                                    -> matches the parts between quotes