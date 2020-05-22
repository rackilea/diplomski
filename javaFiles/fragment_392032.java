@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(value=MoneyAdapter.class, type=Money.class)
})
package com.internal;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;

import com.external.Money;