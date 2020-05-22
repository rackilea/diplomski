package com.internal;

import java.util.Currency;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import com.external.Money;

public class MoneyAdapter extends XmlAdapter<TransportableMoney, Money> {

    @Override
    public Money unmarshal(TransportableMoney v) throws Exception {
        Money money = new Money();
        Currency currency = Currency.getInstance(v.currency);
        money.setCurrency(currency);
        return money;
    }

    @Override
    public TransportableMoney marshal(Money v) throws Exception {
        TransportableMoney transportableMoney = new TransportableMoney();
        transportableMoney.currency = v.getCurrency().getCurrencyCode();
        return transportableMoney;
    }

}