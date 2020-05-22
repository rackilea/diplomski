//Token.java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
class LowLevelToken {
    @XmlAttribute(name = "info-key")
    public String key;
    @XmlAttribute(name = "info-value")
    public String value;

    private LowLevelToken() {}

    public LowLevelToken(String key, String value) {
        this.key = key;
        this.value = value;
    }
}

@XmlRootElement
class HighLevelToken {
    @XmlAttribute(name = "info-1")
    public String info1;
    @XmlAttribute(name = "info-2")
    public String info2;

    private HighLevelToken() {}

    public HighLevelToken(String info1, String info2) {
        this.info1 = info1;
        this.info2 = info2;
    }
}

class TokenWrapper {
    @XmlElement(name="LowLevel")
    public List<LowLevelToken> tokens = new ArrayList<LowLevelToken>();
}

class TokenAdapter extends XmlAdapter<TokenWrapper, Map<String, String>> {
    @Override
    public TokenWrapper marshal(Map<String, String> lowlevelTokens)
            throws Exception {
        TokenWrapper wrapper = new TokenWrapper();
        List<LowLevelToken> elements = new ArrayList<LowLevelToken>();
        for (Map.Entry<String, String> property : lowlevelTokens.entrySet()) {
            elements.add(new LowLevelToken(property.getKey(), property.getValue()));
        }
        wrapper.tokens = elements;
        return wrapper;
    }

    @Override
    public Map<String, String> unmarshal(TokenWrapper tokenWrapper) throws Exception {
        Map<String, String> tokens = null;
        if(tokenWrapper != null && tokenWrapper.tokens != null && !tokenWrapper.tokens.isEmpty()){
            tokens = new HashMap<String, String>();
            for(LowLevelToken token : tokenWrapper.tokens){
                tokens.put(token.key, token.value);
            }
        }
        return tokens;
    }
}

@XmlRootElement(name = "Token")
public class Token {

    HighLevelToken highLevel;
    Map<String, String> lowLevel;

    public HighLevelToken getHighLevel() {
        return highLevel;
    }

    @XmlElement(name = "HighLevel")
    public void setHighLevel(HighLevelToken highLevel) {
        this.highLevel = highLevel;
    }

    public Map<String, String> getLowLevel() {
        return lowLevel;
    }

    @XmlElement(name = "LowLevel")
    @XmlJavaTypeAdapter(TokenAdapter.class)
    public void setLowLevel(Map<String, String> lowLevel) {
        this.lowLevel = lowLevel;
    }
}