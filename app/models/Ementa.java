package models;

import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.db.ebean.*;

@Entity
public class Ementa extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	@Required
	public String description;
	
	@Required
	public String price;
	
	@ManyToOne
	public Restaurante restaurante;

}
