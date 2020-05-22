private static class DeleteTask extends AsyncTask<Customer, Void, Long> {
        private CustomerDao dao;

        DeleteTask (CustomerDao dao) {
            this.dao = dao;
        }

        @Override
        protected Long doInBackground(final Customer... params) {
            return dao.delete(params[0]);;
        }
    }