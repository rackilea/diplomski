public class LabelPostInsertListener implements PostInsertListener {

        public void onPostInsert(PostInsertEvent event)
                throws HibernateException {
            Bucket bucket = (Bucket)event.getEntity();
            for (Label l : bucket.getLabels().values()) {
                l.setBucketId(bucket.getId());
            }

        }
    }