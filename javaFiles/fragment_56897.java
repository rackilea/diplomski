/**
1681         * This method is used to read a token by the {@linkplain #readInt()} method and the {@linkplain #readLong()} method.
1682         *  
1683         * @return the token to parse as integer or long by the calling method.
1684         * @throws IOException throws by the {@link #pdfSource} methods.
1685         */
1686        protected final StringBuilder readStringNumber() throws IOException
1687        {
1688            int lastByte = 0;
1689            StringBuilder buffer = new StringBuilder();
1690            while( (lastByte = pdfSource.read() ) != 32 &&
1691                    lastByte != 10 &&
1692                    lastByte != 13 &&
1693                    lastByte != 60 && //see sourceforge bug 1714707
1694                    lastByte != 0 && //See sourceforge bug 853328
1695                    lastByte != -1 )
1696            {
1697                buffer.append( (char)lastByte );
1698            }
1699            if( lastByte != -1 )
1700            {
1701                pdfSource.unread( lastByte );
1702            }
1703            return buffer;
1704        }