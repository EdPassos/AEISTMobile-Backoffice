package models;

import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.format.Formatters.SimpleFormatter;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Ementa extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static Finder<Long,Ementa> find = new Finder<Long, Ementa>(
			Long.class, Ementa.class);
	
	@Id
	public Long id;
	
	@Required
	public String description;
	
	@Required
	public String price;
	
	@ManyToOne
	public Restaurante restaurante;
	
	public static List<Ementa> all() {
		  return find.all();
	}
	
	public static void create(Ementa ementa) {
		ementa.save();
	}
	
	public static void delete(Long id){
		find.ref(id).delete();
	}
	
	static {
		play.data.format.Formatters.register(Ementa.class, new EmentaFormatter());
	}

	public static class EmentaFormatter extends SimpleFormatter<Ementa> {

		@Override
		public Ementa parse(String text, Locale locale) {
			if (text == null || text.trim().length() == 0)
				return null;
			return Ementa.find.ref(Long.parseLong(text.trim()));
		}

		@Override
		public String print(Ementa value, Locale locale) {
			return (value == null || value.id == null ? "" : value.toString());
		}
	}
	
	@Override
	public String toString() {
		return description;
	}
}
