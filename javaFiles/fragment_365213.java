public class BaseInflaterAdapter<T> extends BaseAdapter {
    private Context m_context;
    private List<T> m_items = new ArrayList<T>();
    private IAdapterViewInflater<T> m_viewInflater;

    public BaseInflaterAdapter(Context context, IAdapterViewInflater<T> viewInflater) {
        m_context = context;
        m_viewInflater = viewInflater;
    }

    public BaseInflaterAdapter(Context context, List<T> items, IAdapterViewInflater<T> viewInflater) {
        m_context = context;
        m_items.addAll(items);
        m_viewInflater = viewInflater;
    }

    // other stuff...

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        return m_viewInflater != null ? m_viewInflater.inflate(m_context, pos, convertView, parent) : null;
    }

}