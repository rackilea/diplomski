package ch.hasselba.xpages.renderkit;

import com.ibm.commons.util.StringUtil;
import com.ibm.xsp.complex.Parameter;
import com.ibm.xsp.render.ResourceRenderer;
import com.ibm.xsp.resource.GenericHeadResource;
import com.ibm.xsp.resource.Resource;
import com.ibm.xsp.util.JSUtil;
import java.io.IOException;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

public class GenericHeadResourceRenderer extends ResourceRenderer {
    public void encodeResource(FacesContext fc, UIComponent uiComponent,
            Resource res) throws IOException {
        GenericHeadResource headRes = (GenericHeadResource) res;
        ResponseWriter rw = fc.getResponseWriter();

        String tagName = headRes.getTagName();
        if (StringUtil.isNotEmpty(tagName)) {

            rw.startElement(tagName, uiComponent);

            List<Parameter> params = headRes.getAttributes();
            if (params != null) {
                for (Parameter param : params) {
                    String name = param.getName();
                    if (StringUtil.isNotEmpty(name)) {
                        String value = param.getValue();
                        if (value == null) {
                            value = "";
                        }
                        if( "content".equals( name ) ){
                            rw.write( value );
                        }else{
                            rw.writeAttribute(name, value, name);
                        }
                    }
                }
            }
            rw.endElement(tagName);
            JSUtil.writeln(rw);
        }
    }
}