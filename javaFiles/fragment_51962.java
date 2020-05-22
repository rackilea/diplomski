ResultSet rs = st.executeQuery(query);
        rs = st.executeQuery(query);
        StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_CURRENT);
        Directory index = new RAMDirectory();
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_CURRENT, analyzer);
        org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
        try {
            while (rs.next()) {
                String imported_by = rs.getString(1);
                Field field = new Field("imported_by", imported_by , Field.Store.YES,          Field.Index.NOT_ANALYZED);
                doc.add(field);
                IndexWriter writer = new IndexWriter(index, config);
                writer.addDocument(doc);
                writer.close();
            }
            printDocument(doc);
        } catch (IOException ex) {
            Logger.getLogger(CIMTPFS_Roche.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CIMTPFS_Roche.class.getName()).log(Level.SEVERE, null, ex);
        }