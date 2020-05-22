public class ProposalsDozerConverter  extends DozerConverter <HashMap<String,Proposal>, HashMap<String,ProposalViewBean>>
                                                                                                implements MapperAware {
    private Mapper mapper;

    public ProposalsDozerConverter() {
        super( ((Class<HashMap<String,Proposal>>) (Class<?>) HashMap.class), (Class<HashMap<String,ProposalViewBean>>) (Class<?>) HashMap.class  );
    }

    @Override
    public HashMap<String, Proposal> convertFrom( HashMap<String, ProposalViewBean> proposalsViewBean, HashMap<String, Proposal> proposals) {

        for (Map.Entry<String, ProposalViewBean> entry : proposalsViewBean.entrySet()){
            Proposal p = mapper.map(entry.getValue(), Proposal.class);
            proposals.put(entry.getKey(), p);
        }

        return proposals;
    }

    @Override
    public HashMap<String, ProposalViewBean> convertTo(HashMap<String, Proposal> proposals, HashMap<String, ProposalViewBean> proposalsViewBean) {

        for (Map.Entry<String, Proposal> entry : proposals.entrySet()){
            ProposalViewBean p = mapper.map(entry.getValue(), ProposalViewBean.class);
            proposalsViewBean.put(entry.getKey(), p);
        }

        return proposalsViewBean;
    }

    @Override
    public void setMapper(Mapper mapper ) {
        this.mapper = mapper;
    }
}