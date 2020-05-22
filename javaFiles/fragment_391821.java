import java.io.Serializable;  
import javax.faces.application.FacesMessage;  
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;  
import javax.faces.event.ActionEvent;  

import org.primefaces.model.DefaultTreeNode;  
import org.primefaces.model.TreeNode;  

@ViewScoped
@ManagedBean (name="masterpage_bean")
public class TreeBean implements Serializable {  

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private TreeNode root;  

    private TreeNode selectedNode;  

    public TreeBean() {  
        root = new DefaultTreeNode("Root", null);  
        TreeNode node0 = new DefaultTreeNode("Node 0", root);  
        TreeNode node1 = new DefaultTreeNode("Node 1", root);  
        TreeNode node2 = new DefaultTreeNode("Node 2", root);  

        TreeNode node00 = new DefaultTreeNode("Some guy G.J", node0);  
        TreeNode node01 = new DefaultTreeNode("Another the third", node0);
    }  

    public TreeNode getRoot() {  
        return root;  
    }  

    public TreeNode getSelectedNode() {  
        return selectedNode;  
    }  

    public void setSelectedNode(TreeNode selectedNode) {  
        this.selectedNode = selectedNode;  
    }  

    public void displaySelectedSingle(ActionEvent event) {  
        if(selectedNode != null) {  
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", selectedNode.getData().toString());  

            FacesContext.getCurrentInstance().addMessage(null, message);  
        }  
    }  
}