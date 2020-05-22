package org.hannibal.utils.view.decorators;    
import java.util.List;

import javax.servlet.jsp.PageContext;

import org.displaytag.decorator.TableDecorator;
import org.displaytag.model.HeaderCell;
import org.displaytag.model.TableModel;
import org.displaytag.util.HtmlAttributeMap;

public class ColspanTableDecorator extends TableDecorator {

    @Override
    public void init(PageContext pageContext, Object decorated,
            TableModel tableModel) {
        super.init(pageContext, decorated, tableModel);
        List headersList = tableModel.getHeaderCellList(); 
        HeaderCell myHeader = (HeaderCell)headersList.get(0);
        HtmlAttributeMap map = myHeader.getHeaderAttributes();
        map.put("colSpan", "2");            
    }   
}