package com.nuance.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nuance.app.Oneaccess;

public class Onedao {
	
	JdbcTemplate template;  
	
	public void setTemplate(JdbcTemplate jt3) {  
	    this.template = template;  
	}  
	

	
	public List<Oneaccess> getOneAccess(){
			return template.query("select * from patient",new RowMapper<Oneaccess>(){  
				        public Oneaccess mapRow(ResultSet rs, int row) throws SQLException {  
				            Oneaccess o=new Oneaccess ();  

				
				o.setPATIENT_SID(rs.getInt(1));  
				o.setPATIENT_FIRST_NAME(rs.getString(2)); 
				o.setPATIENT_MIDDLE_NAME(rs.getString(3)); 
				o.setPATIENT_LAST_NAME(rs.getString(4)); 
			/*	o.setMRN(rs.getString(5)); */   //need to check if mrn exist or not 
				o.setBIRTHDATE(rs.getDate(5)); 
				o.setSSN(rs.getString(6));  
			 
				o.setPATIENT_ADDRESS1(rs.getString(7)); 
				o.setPATIENT_ADDRESS2(rs.getString(8)); 
				o.setPATIENT_CITY(rs.getString(9)); 
			
				o.setPATIENT_ZIP(rs.getString(10)); 
				o.setPHONE_NUMBER(rs.getInt(11));  
				o.setGENDER(rs.getString(12)); 
				o.setMARITAL_STATUS(rs.getString(13)); 
				o.setCONFIDENTIALITY_LEVEL(rs.getInt(14)); 
				o.setPATIENT_TYPE_SID(rs.getInt(15)); 
				o.setPROVINCE_STATE_SID(rs.getString(16)); 
				o.setCOUNTRY_SID(rs.getString(17)); 
				
				return o;
			}
	    });  
	}  

}
