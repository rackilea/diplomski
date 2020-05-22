boolean supportsAIO = AIOSequentialFileFactory.isSupported();

     if (supportsAIO)
     {
        config.setJournalType(JournalType.ASYNCIO);
     }
     else
     {
        config.setJournalType(JournalType.NIO);
     }