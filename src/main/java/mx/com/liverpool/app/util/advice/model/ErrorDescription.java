package mx.com.liverpool.app.util.advice.model;

import java.util.List;

import lombok.Data;


/**
 * Clase Util ErrorDescription
 * @author Eduardo Guillen Maldonado
 * 
 */
@Data
public class ErrorDescription {
	private String propiedad;

	private List<String> error;

	public ErrorDescription(String propiedad, List<String> error) {
		super();
		this.propiedad = propiedad;
		this.error = error;
	}

}
