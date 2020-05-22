ZipOutputStream out = new ZipOutputStream(new FileOutputStream(source));
for( Document m_objectToWrite : MY_DOCUMENTS_LIST ){
    out.putNextEntry(new ZipEntry(path + GIVE_NAME_BASED_ON_CURRENT_DOCUMENT));
    objOut.output(m_objectToWrite.toXml(0), out);
    out.closeEntry();
}

...

out.close();