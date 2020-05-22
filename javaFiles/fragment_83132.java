clearingParents:  while( entry.getKey().ups.size() > 0 ) {

                        for(Node node : entry.getKey().ups) {

                            log.debug("Clearing {}, hash size is {}", node, hash.size());
                            if( node.sizeUps() == 0 ) {
                                node.clear();
                                continue clearingParents;
                            }
                            else {
                                log.debug("was skipped since inserted");
                            }
                        }

                        break clearingParents;
                    }