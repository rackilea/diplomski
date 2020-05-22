public class StepsAdapter extends ArrayAdapter<FirstAidSteps> {

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        ViewHolder holder;
        if (v == null) {
            v = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.stepName = (TextView) v.findViewById(R.id.step_heading);
            holder.steps = (LinearLayout) v.findViewById(R.id.steps);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }

        final FirstAidSteps steps = getItem(position);
        holder.stepName.setText(steps.getStepName());

        holder.steps.removeAllViews();
        for (String step : steps.getSteps()) {
            holder.steps.addView(createStepView(step));
        }

        return v;
    }

    private static class ViewHolder {
        TextView stepName;
        LinearLayout steps;
    }
}