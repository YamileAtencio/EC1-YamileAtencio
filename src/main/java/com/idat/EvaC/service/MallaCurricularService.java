package com.idat.EvaC.service;

import java.util.List;

import com.idat.EvaC.model.MallaCurricular;


public interface MallaCurricularService {
	void guardar(MallaCurricular mallacurricular);
	void actualizar(MallaCurricular mallacurricular);
	void eliminar(Integer id);
	List<MallaCurricular> listar();
	MallaCurricular obtener(Integer id);

}
