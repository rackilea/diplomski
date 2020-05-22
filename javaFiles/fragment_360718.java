package com.felix.dao.interceptor;
import org.hibernate.EmptyInterceptor;

public class CustomDBInterceptor extends EmptyInterceptor {

  @Override
  public String onPrepareStatement(String sql) {
    String commentStr = "/*Comment*/"
    return super.onPrepareStatement(commentStr+sql);
  }

}