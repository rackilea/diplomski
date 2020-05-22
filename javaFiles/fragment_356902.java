326    private View createViewFromResource(int position, View convertView, ViewGroup parent,
327            int resource) {
328        View view;
329        TextView text;
330
331        if (convertView == null) {
332            view = mInflater.inflate(resource, parent, false);
333        } else {
334            view = convertView;
335        }
336
337        try {
338            if (mFieldId == 0) {
339                //  If no custom field is assigned, assume the whole resource is a TextView
340                text = (TextView) view;
341            } else {
342                //  Otherwise, find the TextView field within the layout
343                text = (TextView) view.findViewById(mFieldId);
344            }
345        } catch (ClassCastException e) {
346            Log.e("ArrayAdapter", "You must supply a resource ID for a TextView");
347            throw new IllegalStateException(
348                    "ArrayAdapter requires the resource ID to be a TextView", e);
349        }
350
351        T item = getItem(position);
352        if (item instanceof CharSequence) {
353            text.setText((CharSequence)item);
354        } else {
355            text.setText(item.toString()); // text is null
356        }
357
358        return view;
359    }