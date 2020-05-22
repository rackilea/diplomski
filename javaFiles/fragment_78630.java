package nl.open.mystuff;

import org.alfresco.rad.test.AbstractAlfrescoIT;
import org.alfresco.rad.test.AlfrescoTestRunner;
import org.alfresco.service.cmr.repository.NodeService;

@RunWith(value = AlfrescoTestRunner.class)
public class MyCustomIT extends AbstractAlfrescoIT {

    private NodeService nodeService;
    private MyType myType;

    @Before
    public void setUp() {
        this.nodeService = (NodeService) super.getApplicationContext().getBean("NodeService");
        this.myType = super.getApplicationContext().getBean(MyType.class);
    }
}