package com.example;

import java.util.Collection;

public final class Functions {

     private Functions() {}

     public static <E> String join(Collection<E> collection, String separator) {
         StringBuilder builder = new StringBuilder();

         for (E element : collection) {
             if (builder.length() > 0) {
                 builder.append(separator);
             }

             builder.append(element);
         }

         return builder.toString();
     }

}