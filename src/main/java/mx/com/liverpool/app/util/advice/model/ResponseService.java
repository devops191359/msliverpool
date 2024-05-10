package mx.com.liverpool.app.util.advice.model;

import org.springframework.http.HttpStatus;
import lombok.Data;


/**
 * Clase Util ResponseService
 * @author Eduardo Guillen Maldonado
 * 
 */
@Data
public class ResponseService {

	private String codigo;

	private String mensaje;

	private String folio;

	private Object resultado;

	public ResponseService(HttpStatus status, String codigo, String mensaje, String folio, Object resultado) {
		super();
		this.codigo = String.valueOf(status.value()).concat(codigo).concat(String.valueOf(status.value()));
		this.mensaje = mensaje;
		this.folio = folio;
		this.resultado = resultado;
	}

}
