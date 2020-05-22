package journeys.controller;

import journeys.dao.CompanyDAO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {
    @Autowired
    CompanyDAO companydao ;
    @RequestMapping(value = {"", "/", "list"}, method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("Company/list");

        model.addObject("companies", companydao.f());

        return model;
    }
    public void setCompanydao(CompanyDAO companydao) {
        this.companydao = companydao;
    }


}