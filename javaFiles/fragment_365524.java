package controllers;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import play.mvc.Controller;
import play.mvc.Result;

import play.data.Form;
import play.data.FormFactory;

import views.html.products.details;
import views.html.products.list;

import models.Product;

public class ProductsController extends Controller {

    private Form<Product> productForm;

    @Inject
    public ProductsController(FormFactory formFactory) {
        this.productForm = formFactory.form(Product.class);
    }

    public Result list() {
        List<Product> products = Product.findAll();
        return ok(list.render(products));
    }

    public Result newProduct() {
        return ok(details.render(productForm));
    }

    public Result details(String ean) {
        return TODO;
    }

    public Result save() {
        return TODO;
    }
}