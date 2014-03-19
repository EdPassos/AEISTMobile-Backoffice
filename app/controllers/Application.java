package controllers;

import models.Ementa;
import models.Restaurante;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {
	static Form<Restaurante> restauranteForm = Form.form(Restaurante.class);
	static Form<Ementa> ementaForm = Form.form(Ementa.class);

    public static Result index() {
//        return ok(index.render("Your new application is ready."));
    	return redirect(routes.Application.restaurantes());
    }
    
    public static Result restaurantes() {
    	return ok(
    		    views.html.index.render(Restaurante.all(), restauranteForm)
    		  );
    }
    
    public static Result newRestaurante() {
    	Form<Restaurante> filledForm = restauranteForm.bindFromRequest();
    	if(filledForm.hasErrors()) {
    		return badRequest(
    				views.html.index.render(Restaurante.all(), filledForm)
    				);
    	} else {
    		Restaurante.create(filledForm.get());
    		return redirect(routes.Application.restaurantes());
    	}
    }

    public static Result deleteRestaurante(Long id) {
    	Restaurante.delete(id);
    	return redirect(routes.Application.restaurantes());
    }
    
    public static Result ementas() {
    	return ok(
    			views.html.ementas.render(Ementa.all(), ementaForm,Restaurante.options())
    			);
    }
    
    public static Result newEmenta() {
    	Form<Ementa> filledForm = ementaForm.bindFromRequest();
    	if(filledForm.hasErrors()) {
    		return badRequest(
    				views.html.ementas.render(Ementa.all(), filledForm,Restaurante.options())
    				);
    	} else {
    		Ementa.create(filledForm.get());
    		return redirect(routes.Application.ementas());
    	}
    }
    
    public static Result deleteEmenta(Long id) {
    	Ementa.delete(id);
    	return redirect(routes.Application.ementas());
    }
}