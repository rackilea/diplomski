@Override
public View getView(int position, View convertView, ViewGroup parent) {

    ...

    // Don't show any image before the correct one is downloaded
    viewHolder.imageView.setImageBitmap(null);

    if (viewHolder.task != null) { // Existing task may be executing
        viewHolder.task.cancel(true);
        viewHolder.task = null;
    }

    if (component.getImage() == null) { // Image not downloaded already
        AsyncTask<?,?,?> task = new DownloadImageTask(viewHolder.imageView);
        viewHolder.task = task;
        task.execute(component);
    } else {
        viewHolder.imageView.setImageBitmap(component.getImage());
    }

    return convertView;
}