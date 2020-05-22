package com.basilbourque.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class DailyProduct {
    // date,name,quantity,quality,realmQ,cost
    // 2018-12-29,Fabric,321908,13.55,43.18,15.98
    // 2018-12-29,Clothing,195045,20.55,45.93,123.01
    // 2018-12-29,Visor Cap,126561,17.43,42.32,79.54
    // 2018-12-29,Beer,80109,3.37,17.93,12.38
    // 2018-12-29,Beach goods,75065,11.48,39.73,105.93
    // 2018-12-29,Alcoholic beverages,31215,4.84,27.90,32.29
    // 2018-12-29,Leather goods,19098,23.13,44.09,198.74
    // 2018-12-29,Bags and wallets,7754,23.09,41.34,1176.54

    public enum Header {
        DATE, NAME, QUANTITY, QUALITY, REALMQ, COST;
    }

    // ----------|  Member vars  |-----------------------------------
    public LocalDate localDate;
    public String name;
    public Integer quantity;
    public BigDecimal quality, realmQ, cost;

    // ----------|  Constructor  |-----------------------------------
    public DailyProduct ( LocalDate localDate , String name , Integer quantity , BigDecimal quality , BigDecimal realmq , BigDecimal cost ) {
        this.localDate = Objects.requireNonNull( localDate );
        this.name = Objects.requireNonNull( name );
        this.quantity = Objects.requireNonNull( quantity );
        this.quality = Objects.requireNonNull( quality );
        this.realmQ = Objects.requireNonNull( realmq );
        this.cost = Objects.requireNonNull( cost );
    }

    // ----------|  `Object` overrides  |-----------------------------------
    @Override
    public String toString ( ) {
        return "com.basilbourque.example.DailyProduct{ " +
                "localDate=" + localDate +
                " | name='" + name + '\'' +
                " | quantity=" + quantity +
                " | quality=" + quality +
                " | realmq=" + realmQ +
                " | cost=" + cost +
                " }";
    }

    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        DailyProduct that = ( DailyProduct ) o;
        return localDate.equals( that.localDate ) &&
                name.equals( that.name );
    }

    @Override
    public int hashCode ( ) {
        return Objects.hash( localDate , name );
    }

}