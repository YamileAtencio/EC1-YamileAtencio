package com.idat.EvaC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.EvaC.model.MallaCurricular;
import com.idat.EvaC.service.MallaCurricularService;

@RestController
@RequestMapping("/malla/v1")
public class MallaCurricularController {
	
	@Autowired
	MallaCurricularService service;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<MallaCurricular>> listar(){//INTERACTUA CON HTTP
		return new ResponseEntity<List<MallaCurricular>>(service.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody MallaCurricular mallacurricular){
		service.guardar(mallacurricular);
		return new ResponseEntity<Void>(HttpStatus.CREATED);		
	}
	
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<MallaCurricular> obtenerPorId(@PathVariable Integer id){
		
		MallaCurricular mallacurricular = service.obtener(id);//VALIDO QUE EXISTA
		if(mallacurricular != null) {
			return new ResponseEntity<MallaCurricular>(mallacurricular, HttpStatus.OK);
		}else {
			return new ResponseEntity<MallaCurricular>(mallacurricular, HttpStatus.NOT_FOUND);
		}		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody MallaCurricular mallacurricular){
		
		MallaCurricular m = service.obtener(mallacurricular.getIdMalla());//VALIDO QUE EXISTA
		if(m != null) {
			service.actualizar(mallacurricular);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		MallaCurricular mallacurricular = service.obtener(id);//VALIDO QUE EXISTA
		if(mallacurricular != null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}

}
