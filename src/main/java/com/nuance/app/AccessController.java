package com.nuance.app;

import java.sql.SQLException;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.nuance.app.Clintaccess;
import com.nuance.app.Enscripaccess;


public class AccessController {

	public static void main(String args[]) throws DataAccessException, SQLException, ClassNotFoundException {

		//	Dao classes  of three databases
		Clindao2 cln = new Clindao2();
		Onedao2 onc = new Onedao2();
		Enscripdao2 ens = new Enscripdao2();

		
		//List variables of three databases
		List<Clintaccess> clinAccessList = cln.getClindata();
		
		//for(Clintaccess list:clinAccessList)
		//System.out.println("Clintergrity list  data   :::::"+list);

		List<Enscripaccess> enscripAccessList = ens.getEnscripData();

		
		//Data merging operations
		onc.feedonedataforClintegrity(clinAccessList);
		onc.feedalldataforEnscription(enscripAccessList);
		
		

	}

}
