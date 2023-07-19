package br.com.students.dozer.mapper;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class StudentDozerMapper {

	
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <Y,Z> Z convertOneStudent(Y origem,Class<Z>destino) {
		
		return mapper.map(origem,destino);
	}
	
	public static <Y,Z>List<Z> convertListOfStudents(List<Y>origem,Class<Z> destino){
		
		List<Z>listaDestino = new ArrayList<Z>();
		
		for(Y y:origem) {
			
		listaDestino.add(mapper.map(y,destino));
		}
		return listaDestino;
	}
}
