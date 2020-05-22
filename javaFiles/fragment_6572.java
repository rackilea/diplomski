return ComparisonChain.start()
                      .compare(r1X, r2X)
                      .compare(r1Y, r2Y)
                      .compare(r1Width, r2Width)
                      .compare(r1Height, r2Height)
                      .result();