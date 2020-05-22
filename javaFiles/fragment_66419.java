@EBean
public class ChildAdapter extends RecyclerViewAdapterBase<Child, ChildView> {

@RootContext
Context ctx;
@Bean(ChildFinder.class)
IChildFinder finder;

@Bean
OttoBus mOttoBus;

/**
 * get data by finder
 */
public void initAdapter() {
    mItems = finder.findAll();
}

@Override
public int getItemViewType(int position) {
    return position;
}

@Override
protected ChildView onCreateItemView(ViewGroup parent, int viewType) {
    return ChildView_.build(ctx);
}


@Override
public void setOnClickListener(View v, final Child item) {
    v.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mOttoBus.post(new RequestChildEvent(item));
        }
    });
}
}