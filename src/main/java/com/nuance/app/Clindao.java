package com.nuance.app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nuance.app.Clintaccess;
import com.nuance.app.Clindao;
public class Clindao {

	JdbcTemplate template;  
	
	public void setTemplate(JdbcTemplate jt) {  
	    this.template = template;  
	}  
	


	public List<Clintaccess> getClinAccess(){
		return template.query("select * from patient", new RowMapper<Clintaccess>(){
			public Clintaccess mapRow(ResultSet rs , int row) throws SQLException {
				Clintaccess c = new Clintaccess();
		
				
				c.setSID(rs.getInt(1));
				c.setSSN(rs.getString(2));
				c.setENTERPRISE_NO(rs.getString(3));
				c.setBIRTHDATE(rs.getDate(4));
				c.setADDR_LINE_1(rs.getString(5));
				c.setADDR_LINE_2(rs.getString(6));
				c.setCITY(rs.getString(7));
				c.setPROVINCE_STATE_SID(rs.getInt(8));
				c.setZIP_CODE(rs.getString(9));
				c.setPHONE_NUMBER(rs.getInt(10));
				c.setEMAIL(rs.getString(11));
				c.setNEXT_OF_KIN(rs.getString(12));
				c.setPERMANENT(rs.getString(13));
				c.setBATCH_SID(rs.getInt(14));
				c.setSEX(rs.getString(15));
				c.setORIG_SYSTEM(rs.getInt(16));
				c.setORIG_USER(rs.getString(17));
				c.setORIG_MODE(rs.getString(18));
				c.setCREATE_DATE(rs.getDate(19));
				c.setLAST_MODIFIED_DATE(rs.getDate(20));
				c.setMARITAL_STATUS(rs.getString(21));
				c.setCONFIDENTIALITY_LEVEL(rs.getInt(22));
				c.setLAST_NAME(rs.getString(23));
				c.setFIRST_NAME(rs.getString(24));
				c.setMIDDLE_INITIAL(rs.getString(25));
				c.setCOUNTRY(rs.getString(26));
				c.setPRE_MERGE_SSN(rs.getString(27));
				c.setPRE_MERGE_ENTERPRISE_NO(rs.getString(28));
				c.setPREVIOUS_SSN(rs.getString(29));
				
					
			
				
				
				
				
				
			/*	c.setPATIENT_SID(rs.getInt(1));  
			 c.setSSN(rs.getInt(2)); 
				 c.setBIRTHDATE(rs.getString(4)); 
				
				c.setMRN(rs.getString(5));  //need to check if mrn exist or not 
				c.setADDR_LINE_1(rs.getString(5)); 
				c.setADDR_LINE_2(rs.getString(6)); 
				c.setPATIENT_CITY(rs.getString(7)); 
				c.setPROVINCE_STATE_SID(rs.getString(8)); 

				c.setPATIENT_ZIP(rs.getString(9)); 
				c.setPHONE_NUMBER(rs.getInt(10));  
				c.setMARITAL_STATUS(rs.getString(21));
				c.setCONFIDENTIALITY_LEVEL(rs.getInt(22)); 
				c.setLAST_NAME(rs.getString(23));
				c.setFIRST_NAME(rs.getString(24));
				c.setMIDDLE_INITIAL(rs.getString(25));
				c.setCOUNTRY_SID(rs.getString(26)); */
					
			
				
				
				
				
				return c;  
				
			}
		}) ;  
		
		
		
	}  
	}  
	
