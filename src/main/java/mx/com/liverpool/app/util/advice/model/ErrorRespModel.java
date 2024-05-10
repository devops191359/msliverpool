package mx.com.liverpool.app.util.advice.model;

import java.util.List;

import lombok.Data;


/**
 * Clase Util ErrorRespModel
 * @author Eduardo Guillen Maldonado
 * 
 */
@Data
public class ErrorRespModel {
	private String codigo;
	private String mensaje;
	private String folio;
	private String info;
	private List<String> detalles;
}
