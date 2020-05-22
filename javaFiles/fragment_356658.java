package com.test.web.controllers

import com.test.dao.TestDAO;

@Controller
public class TestController {
    @Autowired
    @Qualifier("myTestDAO")
    private TestDAO testDAO;

    @RequestMapping(value = "/welcome.htm*", method = RequestMethod.GET)
    public ModelMap showWelcomePage() {
        ModelMap model = new ModelMap();
        model.addAttribute("products", testDAO.getOfferedProducts());
        return model;
    }
}