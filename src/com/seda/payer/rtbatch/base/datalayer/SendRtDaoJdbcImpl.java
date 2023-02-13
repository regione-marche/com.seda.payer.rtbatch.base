package com.seda.payer.rtbatch.base.datalayer;


import com.seda.payer.rtbatch.base.commons.EnteDto;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



class SendRtDaoJdbcImpl implements RtRepositoryDao {
	
	Connection connection;
	
	
	
	@Override
	public List<EnteDto> findEnti(String siglaProvincia) throws DaoException {
		CallableStatement pycftsp_lsten_batch = null;
		ResultSet rs = null;
		
		ArrayList<EnteDto> listaEnti = new ArrayList<EnteDto>();
		
		try {
			pycftsp_lsten_batch = connection.prepareCall("{call PYCFTSP_LSTEN_BATCH(?)}");
			
			pycftsp_lsten_batch.setString(1, siglaProvincia);
			
			rs = pycftsp_lsten_batch.executeQuery();
			
			while (rs.next()) {
				EnteDto bean = new EnteDto();
				
				bean.setCCFTIDPA(rs.getString(1));
				bean.setCCFTUSER(rs.getString(2));
				bean.setCCFTPASW(rs.getString(3));
				bean.setCCFTURLI(rs.getString(4));
				bean.setCCFTEMAI(rs.getString(5));
				bean.setCCFTURLR(rs.getString(6));
				bean.setCCFTEMAR(rs.getString(7));
				
				listaEnti.add(bean);
			}
			return listaEnti;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Errore nel recupero degli enti dal database : ", e);
		} finally {
			cleanUp(rs, pycftsp_lsten_batch);
		}
	}
	
	
	
	private void cleanUp(ResultSet rs, CallableStatement cs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (cs != null) {
			try {
				cs.close();
			} catch (SQLException e) {
			}
		}
	}
}
