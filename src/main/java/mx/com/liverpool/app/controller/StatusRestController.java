package mx.com.liverpool.app.controller;


import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import mx.com.liverpool.app.common.Constantes;
import mx.com.liverpool.app.common.Util;
import mx.com.liverpool.app.util.advice.model.ResponseService;



/**
 * Clase Rest Controller StatusRestController
 * @author  Eduardo Guillen Maldonado
 * 
 */
@RestController
@RequestMapping("/status")
public class StatusRestController {

	@Autowired
	private Util util;

	@Value("${info.app.name}")
	private String nombreAplicacion;
	
	@Value("${info.app.version}")
	private String appVersion;


	/**
     *  Método que devuelve el estatus de salud de vida del microservicio
     *  @return object
     *  
     */
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseService getStatus() {
		Map<String, String> status = Map.of("aplicacion", nombreAplicacion, "appVersion", appVersion);
		return new ResponseService(HttpStatus.OK, util.getCodigo(), Constantes.OPERACION_200, util.getFolio(),
				status);
	}


}