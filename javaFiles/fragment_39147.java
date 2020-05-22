package com.puut.bitcoin.controllers;

@Controller
@RequestMapping(value="/")
public class spaController {

  @RequestMapping(method = RequestMethod.GET)
  public String pagIndex(Model model){

     return "index";
  }
}