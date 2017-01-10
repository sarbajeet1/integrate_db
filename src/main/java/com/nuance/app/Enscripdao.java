package com.nuance.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.nuance.app.Enscripaccess;

public class Enscripdao {

	JdbcTemplate template;  
	
	public void setTemplate(JdbcTemplate jt2) {  
	    this.template = template;  
	}  
	


	public List<Enscripaccess> getEnscripaccess(){
		return template.query("select * from patient", new RowMapper<Enscripaccess>(){
			public Enscripaccess mapRow(ResultSet rs , int row) throws SQLException {
				Enscripaccess e = new Enscripaccess();
				
				e.setId(rs.getInt(1)); 
				e.setPATIENT_RSN(rs.getInt(2)); 
				e.setFACILITY_CODE(rs.getString(3)); 
				e.setENTERPRISE_CODE(rs.getString(4));
				e.setMEDICALRECORDNUMBER(rs.getString(5));
				e.setBIRTHDAte(rs.getDate(6));
				e.setSSN(rs.getString(7));
				e.setLAST_FOLDER_ID(rs.getString(8));
				e.setLASTIMAGE_ID(rs.getString(9));
				e.setLAST_ORDER_ID(rs.getInt(10));
				e.setPATIENT_MFPI_RSN(rs.getInt(11));
				e.setPATIENT_TYPE(rs.getInt(12));
				
				
				return e;  
				
			}
	    });  
	}  

}
