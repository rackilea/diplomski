import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class XmlMapperApp {

    public static void main(String[] args) throws Exception {
        File inputFile = new File("./resource/test.xml").getAbsoluteFile();
        File outputFile = new File("./resource/output.xml").getAbsoluteFile();

        Parser parser = new Parser();
        List<Account> accounts = parser.readFromXML(inputFile).getAccountList();
        accounts.remove(0);
        parser.writeToXML(accounts, outputFile);
    }
}

class Parser {

    private XmlMapper xmlMapper;

    public Parser() {
        this.xmlMapper = new XmlMapper();
        this.xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public AccountList readFromXML(File xmlFile) throws IOException {
        return xmlMapper.readValue(xmlFile, AccountList.class);
    }

    public void writeToXML(List<Account> accounts, File output) throws IOException {
        xmlMapper.writeValue(output, new AccountList(accounts));
    }
}

class Account implements Serializable {

    private static final long serialVersionUID = -4816735989159211337L;

    @JacksonXmlProperty(localName = "iban", isAttribute = true)
    private String accountIban;

    @JacksonXmlProperty(localName = "name")
    private String name;

    @JacksonXmlProperty(localName = "currency")
    private String currency;

    @JacksonXmlProperty(localName = "balance")
    private BigDecimal balance;

    @JacksonXmlProperty(localName = "closingDate")
    private String closingDate;

    public Account() {
    }

    public Account(String accountIban, String name, String currency, BigDecimal balance, String closingDate) {
        this.accountIban = accountIban;
        this.name = name;
        this.currency = currency;
        this.balance = balance;
        this.closingDate = closingDate;
    }

    // getters, setters, toString
}

@JacksonXmlRootElement(localName = "accounts")
class AccountList implements Serializable {

    private static final long serialVersionUID = 9215731280802778862L;

    @JacksonXmlProperty(localName = "account")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Account> accountList;

    public AccountList() {
    }

    public AccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    // getters, setters, toString
}