package mx.com.liverpool.app.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mx.com.liverpool.app.common.Constantes;
import mx.com.liverpool.app.common.Util;
import mx.com.liverpool.app.util.advice.model.ResponseService;
import mx.com.liverpool.app.util.advice.model.SEExceptionAPI;

@Slf4j
@RestController
@RequestMapping("/liverpool")
@RequiredArgsConstructor
public class MsLiverpoolController {
	
	
	private final Util util;

	@GetMapping("/test")
	@ResponseStatus(HttpStatus.OK)
	public Object getInfo(@RequestParam(name = "folio", required = true) String folio) throws Exception {
		
		log.info("Entra al metodo test de liverpool");

		Map<String, String> map = new HashMap<>();
		try {
			
			if ("".equals(folio) || folio.isEmpty()) {
				throw new SEExceptionAPI(HttpStatus.BAD_REQUEST, util.getCodigo(), Constantes.OPERACION_400,
						util.getFolio(), Arrays.asList("Parametro Vacio"));
			}
			
			map.put("valorFolio", String.valueOf(folio).concat(new SimpleDateFormat("ddMMyyHHmmss", Locale.UK).format(new Date())));
			return new ResponseService(HttpStatus.OK, util.getCodigo(), Constantes.OPERACION_200, util.getFolio(),
					map);
		} catch (SEExceptionAPI e) {
			throw e;
		} catch (Exception exc) {
			SEExceptionAPI ex = new SEExceptionAPI(HttpStatus.INTERNAL_SERVER_ERROR, util.getCodigo(),
					Constantes.OPERACION_500, util.getFolio(), Arrays.asList(exc.getMessage()));
			throw ex;
		}
	}
}
