package de.scrum_master.stackoverflow;

import org.modelmapper.AbstractConverter;

public class MyConverter extends AbstractConverter<Integer, String> {
  @Override
  protected String convert(Integer source) {
    return source.toString();
  }
}