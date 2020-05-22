package com.internal;

import javax.xml.bind.annotation.XmlRootElement;

import com.external.Money;

@XmlRootElement
public class ExampleRequest {
    private Money money;
    public Money getMoney() { return money; }
    public void setMoney(Money money) { this.money = money; }
}