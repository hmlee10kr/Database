//package com.ji.model;
package pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

import java.util.ArrayList;

public class CoonectDB {
	private Connection conn = null;
	private Statement stmt = null;

	private static final String USERNAME = "s15011025";
	private static final String PASSWORD = "19961218";
	private static final String JDBC = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";

	private String sql;

	public CoonectDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("DB Connection OK!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DB Driver Error!");
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("DB Connection Error!");
		}
	}

	public void createTable(String table, String[] col, int cnt) {
		try {
			String sql = "CREATE TABLE " + table + "(" + col[0] + " VARCHAR2(50) NOT NULL";
			if (cnt == 1)
				sql += ")";
			else if (cnt == 2)
				sql += ", " + col[1] + " VARCHAR2(50) NOT NULL" + ")";

			stmt = conn.createStatement();
			stmt.executeUpdate(sql);

		} catch (Exception se) {
			se.printStackTrace();
			System.out.println("DB init Error!");
		}
	}

	public void initDataBase() {
		try {
			stmt = null;
			String sql1 = "CREATE TABLE CAMPINGCARCOMPANY(" + "COMPANYID VARCHAR2(30) NOT NULL PRIMARY KEY,"
					+ "COMPANYNAME VARCHAR2(30) NOT NULL," + "ADDR VARCHAR2(30) NOT NULL,"
					+ "TEL VARCHAR2(30) NOT NULL," + "CHARGENAME VARCHAR2(50) NOT NULL,"
					+ "CHARGEEMAIL VARCHAR2(50) NOT NULL" + ")";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql1);

			String sql2 = "CREATE TABLE CAMPINGCAR(" + "CARID VARCHAR2(30) NOT NULL PRIMARY KEY,"
					+ "CARNO VARCHAR2(30) NOT NULL," + "CARNAME VARCHAR2(30) NOT NULL," + "PASSENGERNO VARCHAR2(30),"
					+ "CARCOST VARCHAR2(30) NOT NULL," + "COMPANYID VARCHAR2(50) NOT NULL,"
					+ "REGISTRATIONDATE VARCHAR2(50) NOT NULL" + ")";
			stmt = null;
			stmt = conn.createStatement();
			stmt.executeUpdate(sql2);

			String sql3 = "CREATE TABLE RENT(" + "RENTID VARCHAR2(30) NOT NULL PRIMARY KEY,"
					+ "CARID VARCHAR2(30) NOT NULL," + "COMPANYID VARCHAR2(30) NOT NULL,"
					+ "CUSLICENCE VARCHAR2(30) NOT NULL," + "STARTDATE VARCHAR2(50) NOT NULL,"
					+ "RENTPAYMENTDUE VARCHAR2(50) NOT NULL," + "RENTPERIOD VARCHAR2(50) NOT NULL,"
					+ "RENTCOSTS VARCHAR2(50) NOT NULL" + ")";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql3);

			String sql4 = "CREATE TABLE CUSTOMER(" + "CUSLICENCE VARCHAR2(30) NOT NULL PRIMARY KEY,"
					+ "CUSNAME VARCHAR2(30) NOT NULL," + "CUSADDR VARCHAR2(30) NOT NULL,"
					+ "CUSTEL VARCHAR2(30) NOT NULL," + "CUSEMAIL VARCHAR2(50) NOT NULL,"
					+ "CUSPREVDATE VARCHAR2(50) NOT NULL," + "CUSPREVSORT VARCHAR2(50) NOT NULL" + ")";
			stmt = null;
			stmt = conn.createStatement();
			stmt.executeUpdate(sql4);
			String sql5 = "CREATE TABLE REPAIR(" + "REPAIRID VARCHAR2(30) NOT NULL PRIMARY KEY,"
					+ "CARID VARCHAR2(30) NOT NULL," + "SHOPID VARCHAR2(30) NOT NULL,"
					+ "COMPANYID VARCHAR2(30) NOT NULL," + "CUSLICENCE VARCHAR2(50) NOT NULL,"
					+ "REPAIRDATE VARCHAR2(50) NOT NULL," + "REPAIRCOSTS VARCHAR2(50) NOT NULL" + ")";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql5);
			String sql6 = "CREATE TABLE REPAIRSHOP(" + "SHOPID VARCHAR2(30) NOT NULL PRIMARY KEY,"
					+ "SHOPNAME VARCHAR2(30) NOT NULL," + "SHOPADDR VARCHAR2(30) NOT NULL,"
					+ "SHOPTEL VARCHAR2(30) NOT NULL," + "SHOPCHARGENAME VARCHAR2(50) NOT NULL,"
					+ "SHOPCHARGEEMAIL VARCHAR2(50) NOT NULL" + ")";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql6);
		} catch (Exception se) {
			se.printStackTrace();
			System.out.println("DB init Error!");
		}
	}

	public void resetDB() {
		try {
			String str = "";
			StringBuffer strB = new StringBuffer();
			FileReader fr = new FileReader(new File("sql/table.sql"));
			BufferedReader br = new BufferedReader(fr);

			while ((str = br.readLine()) != null)
				strB.append(str);
			br.close();

			String[] sql = strB.toString().split(";");
			stmt = conn.createStatement();

			for (int i = 0; i < sql.length; i++)
				if (!sql[i].trim().equals(""))
					stmt.executeUpdate(sql[i]);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SQL ERROR");
		}
	}

	public void deleteDB() {
		try {
			String sql1 = "DROP TABLE CAMPINGCAR";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql1);
			String sql2 = "DROP TABLE CAMPINGCARCOMPANY";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql2);
			String sql3 = "DROP TABLE REPAIRSHOP";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql3);
			String sql4 = "DROP TABLE CUSTOMER";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql4);
			String sql5 = "DROP TABLE RENT";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql5);
			String sql6 = "DROP TABLE REPAIR";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql6);

			System.out.println("DB Create!");
		} catch (Exception se) {
			se.printStackTrace();
			System.out.println("DB Connection Error!");
		}
	}

	// getTable
	public ArrayList<DescribeTableVO> getTableDescription(String tableName) {
		String sql = "select COLUMN_NAME from COLS where table_name=?";
		PreparedStatement pstmt = null;
		ArrayList<DescribeTableVO> arrDescribeTableVO = new ArrayList<DescribeTableVO>();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tableName.toUpperCase());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("getTableDescription");
				System.out.println(rs.getString("COLUMN_NAME"));
				DescribeTableVO tempDescribeTableVO = new DescribeTableVO(rs.getString("COLUMN_NAME"));
				arrDescribeTableVO.add(tempDescribeTableVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrDescribeTableVO;
	}

	// select
	public ArrayList<CustomerVO> selectCustomer(String select, String where) {
		if (select.equals(""))
			select = "*";
		sql = "select " + select + " from CUSTOMER ";
		if (!where.equals(""))
			sql = sql + " where " + where;

		PreparedStatement pstmt = null;
		ArrayList<CustomerVO> arrCustomerVO = new ArrayList<CustomerVO>();

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				CustomerVO tempCustomerVO = new CustomerVO(rs.getString("CUSLICENCE"), rs.getString("CUSNAME"),
						rs.getString("CUSADDR"), rs.getString("CUSTEL"), rs.getString("CUSEMAIL"),
						rs.getString("CUSPREVDATE"), rs.getString("CUSPREVSORT"));
				arrCustomerVO.add(tempCustomerVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrCustomerVO;
	}

	public ArrayList<CampingCarVO> selectCampingCar(String select, String where) {
		if (select.equals(""))
			select = "*";
		sql = "select " + select + " from CAMPINGCAR ";
		if (!where.equals(""))
			sql = sql + " where " + where;

		PreparedStatement pstmt = null;
		ArrayList<CampingCarVO> arrCampingCarVO = new ArrayList<CampingCarVO>();

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				CampingCarVO tempCampingCarVO = new CampingCarVO(rs.getString("CARID"), rs.getString("CARNO"),
						rs.getString("CARNAME"), rs.getString("PASSENGERNO"), rs.getString("CARCOST"),
						rs.getString("COMPANYID"), rs.getString("REGISTRATIONDATE"));
				arrCampingCarVO.add(tempCampingCarVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrCampingCarVO;
	}

	public ArrayList<CampingCarCompanyVO> selectCampingCarCompany(String select, String where) {
		if (select.equals(""))
			select = "*";
		sql = "select " + select + " from CAMPINGCARCOMPANY ";
		if (!where.equals(""))
			sql = sql + " where " + where;

		PreparedStatement pstmt = null;
		ArrayList<CampingCarCompanyVO> arrCampingCarCompanyVO = new ArrayList<CampingCarCompanyVO>();

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				CampingCarCompanyVO tempCampingCarCompanyVO = new CampingCarCompanyVO(rs.getString("COMPANYID"),
						rs.getString("COMPANYNAME"), rs.getString("ADDR"), rs.getString("TEL"),
						rs.getString("CHARGENAME"), rs.getString("CHARGEEMAIL"));
				arrCampingCarCompanyVO.add(tempCampingCarCompanyVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrCampingCarCompanyVO;
	}

	public ArrayList<RentVO> selectRent(String select, String where) {
		if (select.equals(""))
			select = "*";
		sql = "select " + select + " from RENT ";
		if (!where.equals(""))
			sql = sql + " where " + where;

		PreparedStatement pstmt = null;
		ArrayList<RentVO> arrRentVO = new ArrayList<RentVO>();

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				RentVO tempRentVO = new RentVO(rs.getString("RENTID"), rs.getString("CARID"), rs.getString("COMPANYID"),
						rs.getString("CUSLICENCE"), rs.getString("STARTDATE"), rs.getString("RENTPAYMENTDUE"),
						rs.getString("RENTPERIOD"), rs.getString("RENTCOSTS"));
				arrRentVO.add(tempRentVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrRentVO;
	}

	public ArrayList<RepairShopVO> selectRepairShop(String select, String where) {
		if (select.equals(""))
			select = "*";
		sql = "select " + select + " from REPAIRSHOP ";
		if (!where.equals(""))
			sql = sql + " where " + where;

		PreparedStatement pstmt = null;
		ArrayList<RepairShopVO> arrRepairShopVO = new ArrayList<RepairShopVO>();

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				RepairShopVO tempRepairShopVO = new RepairShopVO(rs.getString("SHOPID"), rs.getString("SHOPNAME"),
						rs.getString("SHOPADDR"), rs.getString("SHOPTEL"), rs.getString("SHOPCHARGENAME"),
						rs.getString("SHOPCHARGEEMAIL"));
				arrRepairShopVO.add(tempRepairShopVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrRepairShopVO;
	}

	public ArrayList<RepairVO> selectRepair(String select, String where) {
		if (select.equals(""))
			select = "*";
		sql = "select " + select + " from REPAIR ";
		if (!where.equals(""))
			sql = sql + " where " + where;

		PreparedStatement pstmt = null;
		ArrayList<RepairVO> arrRepairVO = new ArrayList<RepairVO>();

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				RepairVO tempRepairVO = new RepairVO(rs.getString("REPAIRID"), rs.getString("CARID"),
						rs.getString("SHOPID"), rs.getString("COMPANYID"), rs.getString("CUSLICENCE"),
						rs.getString("REPAIRDATE"), rs.getString("REPAIRCOSTS"));
				arrRepairVO.add(tempRepairVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrRepairVO;
	}

	// delete
	public void deleteCustomer(String condition) {
		String sql = "delete from CUSTOMER ";
		sql += condition;
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteCampingCar(String condition) {
		String sql = "delete from CAMPINGCAR ";
		sql += condition;
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteCampingCarCompany(String condition) {
		String sql = "delete from CAMPINGCARCOMPANY ";
		sql += condition;
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteRent(String condition) {
		String sql = "delete from RENT ";
		sql += condition;
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteRepairShop(String condition) {
		String sql = "delete from REPAIRSHOP ";
		sql += condition;
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteRepair(String condition) {
		String sql = "delete from REPAIR ";
		sql += condition;
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// update
	public void updateCustomer(String set, String where) {
		String sql = "UPDATE CUSTOMER SET " + set + " where " + where;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateCampingCar(String set, String where) {
		String sql = "UPDATE CAMPINGCAR SET " + set + " where " + where;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateCampingCarCompany(String set, String where) {
		String sql = "UPDATE CAMPINGCARCOMPANY SET " + set + " where " + where;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateRent(String set, String where) {
		String sql = "UPDATE RENT SET " + set + " where " + where;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateRepairShop(String set, String where) {
		String sql = "UPDATE REPAIRSHOP SET " + set + " where " + where;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateRepair(String set, String where) {
		String sql = "UPDATE REPAIR SET " + set + " where " + where;
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// insert
	public void insertCustomer(String cusLicence, String cusName, String cusAddr, String cusTel, String cusEmail,
			String cusPrevDate, String cusPrevSort) {
		String sql = "insert into CUSTOMER values (?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cusLicence);
			pstmt.setString(2, cusName);
			pstmt.setString(3, cusAddr);
			pstmt.setString(4, cusTel);
			pstmt.setString(5, cusEmail);
			pstmt.setString(6, cusPrevDate);
			pstmt.setString(7, cusPrevSort);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertCampingCarCompany(String companyID, String comname, String addr, String tel, String chargeName,
			String chargeEMail) {
		String sql = "insert into CAMPINGCARCOMPANY values (?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, companyID);
			pstmt.setString(2, comname);
			pstmt.setString(3, addr);
			pstmt.setString(4, tel);
			pstmt.setString(5, chargeName);
			pstmt.setString(6, chargeEMail);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertCampingCar(String carID, String carNo, String carName, String passengerNo, String carCost,
			String companyID, String registrationDate) {
		String sql = "insert into CAMPINGCAR values (?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carID);
			pstmt.setString(2, carNo);
			pstmt.setString(3, carName);
			pstmt.setString(4, passengerNo);
			pstmt.setString(5, carCost);
			pstmt.setString(6, companyID);
			pstmt.setString(7, registrationDate);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertRent(String rentID, String carID, String comID, String cusLicence, String startDate,
			String rentPaymentDue, String rentPeriod, String rentCosts) {
		String sql = "insert into RENT values (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, rentID);
			pstmt.setString(2, carID);
			pstmt.setString(3, comID);
			pstmt.setString(4, cusLicence);
			pstmt.setString(5, startDate);
			pstmt.setString(6, rentPaymentDue);
			pstmt.setString(7, rentPeriod);
			pstmt.setString(8, rentCosts);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertRepairShop(String shopID, String shopName, String shopAddr, String shopTel, String shopChargeName,
			String shopChargeEmail) {
		String sql = "insert into REPAIRSHOP values (?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, shopID);
			pstmt.setString(2, shopName);
			pstmt.setString(3, shopAddr);
			pstmt.setString(4, shopTel);
			pstmt.setString(5, shopChargeName);
			pstmt.setString(6, shopChargeEmail);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertRepair(String repairID, String carID, String shopID, String comID, String cusLicense,
			String repairDate, String repairCost) {
		String sql = "insert into REPAIR values (?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, repairID);
			pstmt.setString(2, carID);
			pstmt.setString(3, shopID);
			pstmt.setString(4, comID);
			pstmt.setString(5, cusLicense);
			pstmt.setString(6, repairDate);
			pstmt.setString(7, repairCost);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// groupby
	public ArrayList<groupCampingCarVO> groupCampingCar(String select, String group, String having) {
		// select passengerNo, count(*)
		// From CampingCar
		// group by passengerNp
		// having count(*) > 2
		int cnt = 1;
		sql = "select " + select + " from CAMPINGCAR group by " + group;
		if (!(having.equals("")))
			sql = sql + " having " + having;

		PreparedStatement pstmt = null;
		ArrayList<groupCampingCarVO> arrGroupCCVO = new ArrayList<groupCampingCarVO>();

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				groupCampingCarVO tempGroupCCVO = new groupCampingCarVO(rs.getString("PASSENGERNO"),
						Integer.parseInt(rs.getString("COUNT(*)")));
				arrGroupCCVO.add(tempGroupCCVO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrGroupCCVO;
	}

	public ArrayList<groupRepairVO> groupRepair(String select, String group, String having) {
		// select shopID, count(*)
		// From REPAIR
		// group by SHOPID
		// having count(*) >
		sql = "select " + select + " from REPAIR group by " + group;
		if (!(having.equals("")))
			sql = sql + " having " + having;

		PreparedStatement pstmt = null;
		ArrayList<groupRepairVO> arrGroupRVO = new ArrayList<groupRepairVO>();

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				groupRepairVO tempGroupRVO = new groupRepairVO(rs.getString("SHOPID"),
						Integer.parseInt(rs.getString("COUNT(*)")));
				arrGroupRVO.add(tempGroupRVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
		}
		return arrGroupRVO;
	}

	public void closeDB() {
		try {
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
			System.out.println("DB Colse Error!");
		}
	}
	
	//nested Query
		public ArrayList<nested1VO> nested1(String select1, String where1, String select2, String from, String where2) {
			//select carid, carno from campingcar where carid
			//in (select carid from repair from repaircosts = 100000)
			//수리 비용이 100000원인 캠핑카의 id와 번호
			if (select1.equals("")) select1 = "*";
			sql = "select " + select1 + " from CAMPINGCAR where " + where1 + 
					" in (select " + select2 + " from " + from + " where " + where2 + ")";
			//sql = "select carid, carno from CAMPINGCAR where carid in (select carid from REPAIR where repaircosts=100000)";
			System.out.println(sql);
			PreparedStatement pstmt = null;
			ArrayList<nested1VO> arrNestVO = new ArrayList<nested1VO>();

			try {
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					nested1VO tempNestVO = new nested1VO(rs.getString("CARID"), rs.getString("CARNO"));
					arrNestVO.add(tempNestVO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null && !pstmt.isClosed())
						pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return arrNestVO;
		}
		public ArrayList<nested2VO> nested2(String select1, String where1, String select2, String from, String where2) {
			//select repairid, companyid from repair where companyid in
			//(select companyid from campingcar where pasengerno = 6)
			//승차 인원이 6명인 캠핑카의 수리ID와 회사 ID
			if (select1.equals("")) select1 = "*";
			sql = "select " + select1 + " from REPAIR where " + where1
					+ " in (select " + select2 + " from " + from + " where " + where2 + ")";
			
			PreparedStatement pstmt = null;
			ArrayList<nested2VO> arrNestVO = new ArrayList<nested2VO>();

			try {
				pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();

				while (rs.next()) {
					nested2VO tempNestVO = new nested2VO(rs.getString("REPAIRID"), rs.getString("COMPANYID"));
					arrNestVO.add(tempNestVO);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null && !pstmt.isClosed())
						pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return arrNestVO;
		}
}