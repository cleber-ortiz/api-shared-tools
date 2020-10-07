package br.com.tijo.api.shared.tools;

import java.util.ArrayList;
import java.util.List;

import br.com.tijo.api.shared.tools.exception.MapperException;

public class MapperTools <E, D> {

	public static String MSG_ERROR_DTO_NULL() {return "Dto is null";}
	public static String MSG_ERROR_PROPERTY_ERROR(Exception ex) {
		StringBuilder sbError = new StringBuilder();
		sbError.append("Falha convertendo alguma propriedade. (");
		sbError.append(ex.getMessage());
		sbError.append(")");
		return sbError.toString();
	}
	
	
	private IMapper<E,D> mapper;

	public MapperTools(IMapper <E, D> _mapper) {
		mapper = _mapper;
	}


	public E convertFromDtoToEntity(D dto) throws MapperException {
		if (dto == null) {
			return null;
		} 
		return mapper.fromDtoToEntity(dto);
	}
	public D convertFromEntityToDto(E entidade) throws MapperException {
		if (entidade == null) {
			return null;
		} 
		return mapper.fromEntityToDto(entidade);
	}


	public List<D> convertFromListEntityToListDto(List<E> lstEntity) throws MapperException {
		List<D> lstSaida = new ArrayList<>();

		if (lstEntity != null) {
			for (int i = 0; i < lstEntity.size(); i++) {
				lstSaida.add(this.convertFromEntityToDto(lstEntity.get(i)));

			}
		}

		return lstSaida;
	} 
	public List<E> convertFromListDtoToListEntity(List<D> lstDto) throws MapperException {
		List<E> lstSaida = new ArrayList<>();

		if (lstDto != null) {
			for (int i = 0; i < lstDto.size(); i++) {
				lstSaida.add(this.convertFromDtoToEntity(lstDto.get(i)));

			}
		}

		return lstSaida;
	} 
	
}
