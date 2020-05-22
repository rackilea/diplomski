@Override
public View onCreateView(LayoutInflater p_Inflater, ViewGroup p_Container,
        Bundle p_SavedInstanceState) 
{

    View v_View = p_Inflater.inflate(R.layout.moduleslist_activity, p_Container);
    m_ListView = (ListView) v_View.findViewById(R.id.modules_list_id_list_view);
    m_ListView.setOnItemClickListener(onItemClick());

    return v_View;
}