package mx.com.liverpool.app.util.advice.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;





/**
 * Clase de tipo TrazaModel
 * @author Eduardo Guillen Maldonado
 * 
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class TrazaModel implements Serializable {

	private static final long serialVersionUID = -5044065324936924819L;

	private String ipOrigen;

	private String fechaTransaccion;

	private String metodo;

	private Object requestBody;

}
