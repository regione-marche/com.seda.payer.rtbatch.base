package com.seda.payer.rtbatch.base.datalayer;


import com.seda.payer.rtbatch.base.commons.EnteDto;

import java.util.List;



public interface RtRepositoryDao {
	
	List<EnteDto> findEnti(String siglaProvincia) throws DaoException;
	
}
