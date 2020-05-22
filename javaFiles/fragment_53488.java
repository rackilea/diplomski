VectorDumper.main(new String[] 
            { "-i",
            OUTPUT_DIR + "/topic-term-dist/part-m-00000", "-o",
            OUTPUT_DIR + "/results", "-d",
                OUTPUT_DIR + "/dictionary.file-0", "-dt", "sequencefile",
            "-sort", "true", "-vs", "20" });