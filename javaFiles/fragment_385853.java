package org.somepackage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;

public class MyCustomOpenSessionInViewFilter extends OpenSessionInViewFilter {

  @Override
  public boolean shouldNotFilter( HttpServletRequest request ) {
      return request.getRequestURI().contains( ".flow" );
  }   
}