void makeReadOnly(Document doc)
{
     synchronized(readWriteLocks)
     {
         doc->m_isWritable = false;
     }
}