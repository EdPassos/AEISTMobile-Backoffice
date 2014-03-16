package models;

import java.util.List;

import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.db.ebean.*;

@Entity
public class Restaurante extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6528261922037833382L;
	
	public static Finder<Long,Restaurante> find = new Finder<Long, Restaurante>(
			Long.class, Restaurante.class);
	@Id
	public Long id;
	
	@Required
	public String name;
	
	public String description;
	
	public static List<Restaurante> all() {
		  return find.all();
	}
	
	public static void create(Restaurante restaurante) {
		restaurante.save();
	}
	
	public static void delete(Long id){
		find.ref(id).delete();
	}
}
