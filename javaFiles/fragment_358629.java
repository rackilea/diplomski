//Match did not succeed but no exception was thrown.
                     //Either we have the matching strategy wrong or the
                     //connection died while being checked.  We need to
                     //distinguish these cases, but for now we always
                     //destroy the connection.
                     log.warn("Destroying connection that could not be successfully matched: " + cl);