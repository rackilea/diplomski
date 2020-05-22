wpath ourPath(pDirectory);
wdirectory_iterator endIter;
for (wdirectory_iterator iter(ourPath); iter != endIter; ++iter)
{
 pContents.push_back(iter->leaf());
}