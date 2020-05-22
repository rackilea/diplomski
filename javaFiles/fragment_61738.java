private class JobFilter extends Filter {
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        if (mOriginalValues == null) {
            synchronized (mLock) {
                mOriginalValues = new ArrayList<JobsGetSet>(rowItems);
            }
        }

        if (constraint == null || constraint.length() == 0) {
            synchronized (mLock) {
                results.values = mOriginalValues;
                results.count = mOriginalValues.size();
            }
        }
        else {
            String con = constraint.toString();
            List<JobsGetSet> values = mOriginalValues;
            int count = values.size();

            List<JobsGetSet> newValues = new ArrayList<JobsGetSet>(count);

            for (int i = 0; i < count; i++) {
                JobsGetSet data = values.get(i);

                //Here is where you compare the constraint(title/address) with values in your JobsGetSet, or any other logic
                String s = data.getTitle();
                if (s.equalsIgnoreCase(con)) {
                    newValues.add(data);
                }
            }

            results.values = newValues;
            results.count = newValues.size();
        }

        return results;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        // noinspection unchecked
        mObjects = (List<JobsGetSet>) results.values;
        notifyDataSetChanged();
        clear();
        addAll(mObjects);
        if (results.count > 0) {
            notifyDataSetChanged();
        }
        else {
        }
    }
}