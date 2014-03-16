package controllers;

import models.Restaurante;
import play.*;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	static Form<Restaurante> restauranteForm = Form.form(Restaurante.class);

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
}