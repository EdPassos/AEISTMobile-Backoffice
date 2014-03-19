package models;

import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.format.Formatters.SimpleFormatter;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

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
	
	static {
		play.data.format.Formatters.register(Restaurante.class, new RestauranteFormatter());
	}
	public static class RestauranteFormatter extends SimpleFormatter<Restaurante> {

		@Override
		public Restaurante parse(String text, Locale arg1)
				throws ParseException {
			if (text == null || text.trim().length() == 0)
				return null;
			return Restaurante.find.ref(Long.parseLong(text.trim()));		}

		@Override
		public String print(Restaurante restaurante, Locale arg1) {
			return (restaurante == null || restaurante.id == null ? "" : restaurante.id.toString());
		}

	}
	
	@Override
	public String toString() {
		return name;
	}
	

    public static Map<String,String> options() {
        Map<String,String> options = new LinkedHashMap<String,String>();
        for(Restaurante c: all()) {
            options.put(c.id.toString(), c.name);
        }
        return options;
    }
	
}
