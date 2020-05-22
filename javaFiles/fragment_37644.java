public class Main {

    private static InternalKnowledgeBase createKnowledgeBaseFromSpreadsheet() throws Exception {

        DecisionTableConfiguration decisionTableConfiguration = KnowledgeBuilderFactory.newDecisionTableConfiguration();
        decisionTableConfiguration.setInputType(DecisionTableInputType.XLS);
        KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        File file = new File("folder/Discount.xls");
        Resource resourceFile = ResourceFactory.newFileResource(file);
        knowledgeBuilder.add(resourceFile, ResourceType.DTABLE, decisionTableConfiguration);

        if (knowledgeBuilder.hasErrors()) {
            throw new RuntimeException(knowledgeBuilder.getErrors().toString());
        }

        InternalKnowledgeBase internalKnowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        Collection<KiePackage> kiePackages = knowledgeBuilder.getKnowledgePackages();
        internalKnowledgeBase.addPackages(kiePackages);
        return internalKnowledgeBase;
    }

    public static void main(String[] args) {

        (new Main()).run();
    }

    public void run() {
        System.out.println("--- Start Code ---");
        StatelessKieSession session = null;

        try {
            InternalKnowledgeBase knowledgeBase = createKnowledgeBaseFromSpreadsheet();
            session = knowledgeBase.newStatelessKieSession();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Customer customer = new Customer(CustomerType.INDIVIDUAL, 1);
        System.out.println(customer.toString());
        session.execute(customer);
        System.out.println(customer.toString());
        System.out.println("--- End Code ---");
    }
}