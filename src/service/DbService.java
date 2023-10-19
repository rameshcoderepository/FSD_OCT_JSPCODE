package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.PrimaryData;
import bean.SecondaryData;

public class DbService {

	public static List<PrimaryData> getPrimaryData() {

		List<PrimaryData> primaryList = new ArrayList<PrimaryData>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/samplecrud", "root", "admin");
			Statement st = con.createStatement();

			ResultSet res = st.executeQuery("select * from primarydata");

			while (res.next()) {
				PrimaryData primarydata = new PrimaryData();
				String mob = res.getString("mobilenumber");
				String name = res.getString("name");

				primarydata.setMobilenumber(mob);
				primarydata.setName(name);

				primaryList.add(primarydata);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return primaryList;
	}

	public static List<SecondaryData> getSecondaryData() {
		List<SecondaryData> secondaryList = new ArrayList<SecondaryData>();

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/samplecrud", "root", "admin");
			Statement st = con.createStatement();

			ResultSet res = st.executeQuery("select * from secondarydata");

			while (res.next()) {
				SecondaryData secondarydata = new SecondaryData();
				String mob = res.getString("mobilenumber");
				String address = res.getString("address");

				secondarydata.setMobilenumber(mob);
				secondarydata.setAddress(address);

				secondaryList.add(secondarydata);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return secondaryList;
	}
}
