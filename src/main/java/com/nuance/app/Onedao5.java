package com.nuance.app;

import java.util.ArrayList;

import java.util.List;

import org.springframework.dao.DataAccessException;

import java.sql.*;

import com.nuance.app.Oneaccess;

public class Onedao5 {

	public List<Oneaccess> list = new ArrayList<Oneaccess>();

	public List<Oneaccess> getallDataForOneHC() throws SQLException, DataAccessException {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onehc", "root", "system");
			Statement s = con.createStatement();

			ResultSet rs = s.executeQuery("select * from patient");
			Oneaccess o = new Oneaccess();
			while (rs.next()) {

				o.setPATIENT_SID(rs.getInt(1));
				o.setPATIENT_FIRST_NAME(rs.getString(2));
				o.setPATIENT_MIDDLE_NAME(rs.getString(3));
				o.setPATIENT_LAST_NAME(rs.getString(4));
				/* o.setMRN(rs.getString(5)); */ // need to check if mrn exist
													// or not
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

				list.add(o);

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);

		}
		return list;

	}

	public String feedonedataforClintegrity(List<Clintaccess> clinAccessList)
			throws SQLException, DataAccessException, ClassNotFoundException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onehc", "root", "system");
		Class.forName("com.mysql.jdbc.Driver");
		Statement s = con.createStatement();
		String clinSSN;
		boolean isPatienPresentInOneHC = false;

		for (Clintaccess clintaccess : clinAccessList) {
			try {

				String bdstring = "";
				if(clintaccess.getBIRTHDATE()!= null){
					bdstring = "'"+clintaccess.getBIRTHDATE()+"'";
				}
				else{
					bdstring= "NULL";
				}
				
				
				clinSSN = clintaccess.getSSN();

				isPatienPresentInOneHC = doesPatientExistinOneHC(clinSSN);

				if (!isPatienPresentInOneHC) {
					String sql = "insert into patient (patient_first_name,patient_middle_name,patient_last_name,birth_date,ssn,patient_address_1,patient_address_2,patient_city,patient_zip,phone_number,gender,marital_status,confidential_level,patient_type_id,created_by,created_date,updated_by,updated_date,province_state_id,country_id) values ('"
							+ clintaccess.getFIRST_NAME() + "','" + clintaccess.getMIDDLE_INITIAL() + "','"
							+ clintaccess.getLAST_NAME() + "','" + bdstring + "','"
							+ clintaccess.getSSN() + "','" + clintaccess.getADDR_LINE_1() + "','"
							+ clintaccess.getADDR_LINE_2() + "','" + clintaccess.getCITY() + "','"
							+ clintaccess.getZIP_CODE() + "'," + clintaccess.getPHONE_NUMBER() + ",'" + null + "','"
							+ clintaccess.getMARITAL_STATUS() + "'," + clintaccess.getCONFIDENTIALITY_LEVEL() + ","
							+ null + ",'admin'," + null + ",'" + null + "'," + null + ","
							+ clintaccess.getPROVINCE_STATE_SID() + "," + null + ")";
				
					
					int i=s.executeUpdate(sql);
					
					
					
					
					System.out.println("sql:clintaccess::::===" + i);

				} // End of if (!isPatienPresentInOneHC)

			} catch (Exception e) {
				System.out.println("in first catch");
				System.out.println(e);

			} finally {

			} // End of finally

		}
		con.close();
		String i = "records inserted";

		return i;
	}

	public String feedalldataforEnscription(List<Enscripaccess> enscripAccessList)
			throws SQLException, DataAccessException, ClassNotFoundException {

	
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onehc", "root", "system");

			Statement s = con.createStatement();
			String enscripSSN;
			boolean isPatienPresentInOneHC = false;

			for (Enscripaccess enscripaccess : enscripAccessList) {
				try {	
					enscripSSN = enscripaccess.getSSN();

					isPatienPresentInOneHC = doesPatientExistinOneHC(enscripSSN);
					
					String bdStr = "";
					
					if(enscripaccess.getBIRTHDAte() != null){
						bdStr = "'" + enscripaccess.getBIRTHDAte() + "'";
					}else{
						bdStr = "NULL";
					}
					
					if (!isPatienPresentInOneHC) {
						
						
					
				String sql = "insert into patient (patient_first_name,patient_middle_name,patient_last_name,birth_date,ssn,patient_address_1,patient_address_2,patient_city,patient_zip,phone_number,gender,marital_status,confidential_level,patient_type_id,created_by,created_date,updated_by,updated_date,province_state_id,country_id) values ('"
						+ null + "','" + null + "','" + null + "'," + bdStr + ",'"
						+ enscripaccess.getSSN() + "','" + null + "','" + null + "','" + null + "','" + null + "',"
						+ null + ",'" + null + "','" + null + "'," + null + "," + enscripaccess.getPATIENT_TYPE()
						+ ",'admin'," + null + ",'" + null + "'," + null + "," + null + "," + null + ")";

				System.out.println("sql:enscripaccess::::===" + sql);
				;
				s.executeUpdate(sql);
				
					}
			

		} catch (Exception e) {
			System.out.println("in second catch");
			System.out.println(e);

		} finally {

		}
			}
		String i = "records inserted";

		return i;

	}// End of method feedonedataforEnscription

	public boolean doesPatientExistinOneHC(String inputSSN) throws SQLException {

		boolean isPatientPresentInDB = false;
		int count = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onehc", "root", "system");
			ResultSet resultSet = null;
			Statement s = con.createStatement();
			String sql = "Select count(*) from patient where ssn ='" + inputSSN + "'";
			resultSet = s.executeQuery(sql);

			while (resultSet.next()) {
				count = resultSet.getInt(1);
			}
			if (count > 0) {
				isPatientPresentInDB = true;
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		return isPatientPresentInDB;

	}// End of doesPatientExist(String SSN)

}
