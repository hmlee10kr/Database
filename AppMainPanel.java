//package com.ji.ui;
//import com.ji.model.*;
package pro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AppMainPanel extends JPanel implements ActionListener {
	private JLabel titleData;
	private JButton cmbMenu1, cmbMenu2;
	private JButton btnSelect, btnInsert;
	private JButton btnSelect1, btnInsert1;
	private JButton btnSelect2, btnInsert2;
	private JButton btnSelect3, btnInsert3;
	private JButton btnSelect4, btnInsert4;
	private JButton btnSelect5, btnInsert5;
	private JTextField txtSelect;
	private JTextField txtSelect1;
	private JTextField txtSelect2;
	private JTextField txtSelect3;
	private JTextField txtSelect4;
	private JTextField txtSelect5;
	private JPanel tempPanel;
	private JPanel tempPanel1;
	private JPanel tempPanel2;
	private JPanel tempPanel3, tempPanel4, tempPanel5;
	private JLabel lblSelect, lblInsert, lblSelect1, lblInsert1, lblSelect2, lblInsert2, lblSelect3, lblInsert3;
	private JLabel lblSelect4, lblInsert4, lblSelect5, lblInsert5;
	private JLabel lblID, lblAge, lblRank, lblJob, lblReserve;
	private JLabel lblID1, lblAge1, lblRank1, lblJob1, lblReserve1;
	private JLabel lblID2, lblAge2, lblRank2, lblJob2, lblReserve2;
	private JLabel lblID3, lblAge3, lblRank3, lblJob3, lblReserve3;
	private JLabel lblID4, lblAge4, lblRank4, lblJob4, lblReserve4;
	private JLabel lblID5, lblAge5, lblRank5, lblJob5, lblReserve5;
	private JLabel lblSix, lblSeven, lblEight;
	private JTextField txtSix, txtSeven, txtEight;
	private JLabel lblSix1, lblSeven1, lblEight1;
	private JTextField txtSix1, txtSeven1, txtEight1;
	private JLabel lblSix2, lblSeven2, lblEight2;
	private JTextField txtSix2, txtSeven2, txtEight2;
	private JLabel lblSix3, lblSeven3, lblEight3;
	private JTextField txtSix3, txtSeven3, txtEight3;
	private JLabel lblSix4, lblSeven4, lblEight4;
	private JTextField txtSix4, txtSeven4, txtEight4;
	private JLabel lblSix5, lblSeven5, lblEight5;
	private JTextField txtSix5, txtSeven5, txtEight5;
	private JTextField txtID, txtAge, txtRank, txtJob, txtReserve;
	private JTextField txtID1, txtAge1, txtRank1, txtJob1, txtReserve1;
	private JTextField txtID2, txtAge2, txtRank2, txtJob2, txtReserve2;
	private JTextField txtID3, txtAge3, txtRank3, txtJob3, txtReserve3;
	private JTextField txtID4, txtAge4, txtRank4, txtJob4, txtReserve4;
	private JTextField txtID5, txtAge5, txtRank5, txtJob5, txtReserve5;
	private JPanel mini, mini1, mini2, mini3, mini4, mini5;
	private JLabel title, title1, title3, title2, title4, title5;

	private CoonectDB dbConnect;
	private DefaultTableModel model;
	private JTable dataTable;
	private DefaultTableModel model1;
	private JTable dataTable1;
	private DefaultTableModel model2;
	private JTable dataTable2;
	private DefaultTableModel model3;
	private JTable dataTable3;
	private DefaultTableModel model4;
	private JTable dataTable4;
	private DefaultTableModel model5;
	private JTable dataTable5;

	private JButton btnJoinSearch, btnInit, btnDelete, btnUpdate;
	private JButton btnInit1, btnDelete1, btnUpdate1;
	private JButton btnInit2, btnDelete2, btnUpdate2;
	private JButton btnInit3, btnDelete3, btnUpdate3;
	private JButton btnInit4, btnDelete4, btnUpdate4;
	private JButton btnInit5, btnDelete5, btnUpdate5;
	// -----
	private JPanel searchPanel;
	private JTextField searchField;
	private JButton searchButt;
	private JPanel searchMini;
	private JLabel searchLbl;
	private JScrollPane mainScrollPane, scrollPane, scrollPane1, scrollPane2, scrollPane3, scrollPane4, scrollPane5;

	private JLabel lblWhere, lblWhere1, lblWhere2, lblWhere3, lblWhere4, lblWhere5;
	private JTextField txtWhere, txtWhere1, txtWhere2, txtWhere3, txtWhere4, txtWhere5;

	private String[] tableName = { "CAMPINGCAR", "CAMPINGCARCOMPANY", "REPAIRSHOP", "CUSTOMER", "RENT", "REPAIR" };

	private String select1 = "";
	private String where = "";
	private String select2 = "";
	private String from = "";
	private String where2 = "";

	private JLabel groupSelect, groupFrom, groupGroupby, groupHaving;
	private JTextField txtGroupSelect, txtGroupFrom, txtGroupGroupby, txtGroupHaving;
	private JButton btnGroupSelect, btnGroupFrom, btnGroupby, btnGroupHaving;

	private JLabel lblSelectTWO, lblSelectTWO1, lblSelectTWO2, lblSelectTWO3, lblSelectTWO4, lblSelectTWO5;
	private JLabel lblFrom, lblFrom1, lblFrom2, lblFrom3, lblFrom4, lblFrom5;
	private JTextField txtSelectTWO, txtSelectTWO1, txtSelectTWO2, txtSelectTWO3, txtSelectTWO4, txtSelectTWO5;
	private JTextField txtFrom, txtFrom1, txtFrom2, txtFrom3, txtFrom4, txtFrom5;
	
	private JLabel lblWhereTWO, lblWhereTWO1, lblWhereTWO2, lblWhereTWO3, lblWhereTWO4, lblWhereTWO5;
	private JTextField txtWhereTWO, txtWhereTWO1, txtWhereTWO2, txtWhereTWO3, txtWhereTWO4, txtWhereTWO5;

	public AppMainPanel() {
		setPreferredSize(new Dimension(1600, 1300));
		setBackground(Color.WHITE);
		setLayout(null);

		dbConnect = new CoonectDB();
		dbConnect.deleteDB();
		dbConnect.initDataBase();
		dbConnect.resetDB();

		cmbMenu1 = new JButton("MANAGER");
		cmbMenu1.setBounds(10, 10, 120, 30);
		cmbMenu1.addActionListener(this);
		add(cmbMenu1);

		cmbMenu2 = new JButton("CUSTOMER");
		cmbMenu2.setBounds(140, 10, 120, 30);
		cmbMenu2.addActionListener(this);
		add(cmbMenu2);

		titleData = new JLabel("CAMPING CAR DATABASE");
		titleData.setBounds(680, 10, 300, 30);
		titleData.setFont(new Font("Consolas", Font.BOLD, 20));
		add(titleData);

		btnJoinSearch = new JButton("GROUP BY");
		btnJoinSearch.setBounds(1200, 10, 120, 30);
		btnJoinSearch.addActionListener(this);
		add(btnJoinSearch);

		btnInit = new JButton("INIT");
		btnInit.setBounds(1350, 10, 120, 30);
		btnInit.addActionListener(this);
		add(btnInit);

		tempPanel = new JPanel();
		tempPanel.setBounds(10, 50, 1580, 1480);
		tempPanel.setPreferredSize(new Dimension(1580, 1280));
		tempPanel.setBackground(Color.LIGHT_GRAY);
		tempPanel.setLayout(null);
		add(tempPanel);
		// --------------------
		tempPanel.setVisible(false);
		
		mainScrollPane = new JScrollPane(tempPanel);
		mainScrollPane.setBounds(10, 50, 1580, 800);
		add(mainScrollPane);
		
		// -----------------------------panel1
		title = new JLabel("[CAMPING CAR]");
		title.setFont(new Font("Consolas", Font.BOLD, 16));
		title.setBounds(10, 5, 300, 30);
		tempPanel.add(title);

		lblSelect = new JLabel("SELECT");
		lblSelect.setBounds(50, 20, 100, 30);
		tempPanel.add(lblSelect);

		lblSelectTWO = new JLabel("SELECT");
		lblSelectTWO.setBounds(194, 20, 100, 30);
		tempPanel.add(lblSelectTWO);

		txtSelect = new JTextField(680);
		txtSelect.setBounds(50, 50, 124, 30);
		tempPanel.add(txtSelect);

		txtSelectTWO = new JTextField(680);
		txtSelectTWO.setBounds(194, 50, 124, 30);
		tempPanel.add(txtSelectTWO);

		lblWhere = new JLabel("WHERE");
		lblWhere.setBounds(338, 20, 100, 30);
		tempPanel.add(lblWhere);

		lblFrom = new JLabel("FROM");
		lblFrom.setBounds(482, 20, 100, 30);
		tempPanel.add(lblFrom);
		
		lblWhereTWO =new JLabel("WHERE");
		lblWhereTWO.setBounds(626, 20, 100, 30);
		tempPanel.add(lblWhereTWO);

		txtWhere = new JTextField(680);
		txtWhere.setBounds(338, 50, 124, 30);
		tempPanel.add(txtWhere);

		txtFrom = new JTextField(680);
		txtFrom.setBounds(482, 50, 124, 30);
		tempPanel.add(txtFrom);
		
		txtWhereTWO=new JTextField(680);
		txtWhereTWO.setBounds(626, 50, 124, 30);
		tempPanel.add(txtWhereTWO);

		btnSelect = new JButton("SELECT");// ----------------
		btnSelect.setBounds(220, 90, 100, 30);
		btnSelect.addActionListener(this);
		tempPanel.add(btnSelect);

		btnDelete = new JButton("DELETE");
		btnDelete.setBounds(340, 90, 100, 30);
		btnDelete.addActionListener(this);
		tempPanel.add(btnDelete);

		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(460, 90, 100, 30);
		btnUpdate.addActionListener(this);
		tempPanel.add(btnUpdate);

		lblInsert = new JLabel("INSERT");
		lblInsert.setBounds(50, 120, 100, 30);
		tempPanel.add(lblInsert);
		lblID = new JLabel("CARID");
		lblID.setBounds(50, 150, 70, 30);
		tempPanel.add(lblID);

		txtID = new JTextField(100);
		txtID.setBounds(130, 150, 70, 30);
		txtID.addActionListener(this);
		tempPanel.add(txtID);

		lblAge = new JLabel("CARNO");
		lblAge.setBounds(210, 150, 70, 30);
		tempPanel.add(lblAge);

		txtAge = new JTextField(100);
		txtAge.setBounds(290, 150, 70, 30);
		txtAge.addActionListener(this);
		tempPanel.add(txtAge);

		lblRank = new JLabel("CARNAME");
		lblRank.setBounds(370, 150, 70, 30);
		tempPanel.add(lblRank);

		txtRank = new JTextField(100);
		txtRank.setBounds(450, 150, 70, 30);
		txtRank.addActionListener(this);
		tempPanel.add(txtRank);

		lblJob = new JLabel("PASS_NO");
		lblJob.setBounds(530, 150, 70, 30);
		tempPanel.add(lblJob);

		txtJob = new JTextField(100);
		txtJob.setBounds(610, 150, 70, 30);
		txtJob.addActionListener(this);
		tempPanel.add(txtJob);

		lblReserve = new JLabel("CARCOST");
		lblReserve.setBounds(50, 180, 70, 30);
		tempPanel.add(lblReserve);

		txtReserve = new JTextField(100);
		txtReserve.setBounds(130, 180, 70, 30);
		txtReserve.addActionListener(this);
		tempPanel.add(txtReserve);

		lblSix = new JLabel("COMID");
		lblSix.setBounds(210, 180, 70, 30);
		tempPanel.add(lblSix);

		txtSix = new JTextField(100);
		txtSix.setBounds(290, 180, 70, 30);
		txtSix.addActionListener(this);
		tempPanel.add(txtSix);

		lblSeven = new JLabel("REGIS DATE");
		lblSeven.setBounds(370, 180, 70, 30);
		tempPanel.add(lblSeven);

		txtSeven = new JTextField(100);
		txtSeven.setBounds(450, 180, 70, 30);
		txtSeven.addActionListener(this);
		tempPanel.add(txtSeven);

		btnInsert = new JButton("INSERT");
		btnInsert.setBounds(340, 225, 100, 30);
		btnInsert.addActionListener(this);
		tempPanel.add(btnInsert);

		model = new DefaultTableModel();
		dataTable = new JTable();
		dataTable.setPreferredScrollableViewportSize(dataTable.getPreferredSize());

		dataTable.setFillsViewportHeight(true);
		dataTable.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable.setRowHeight(20);
		dataTable.getTableHeader().setReorderingAllowed(false);

		mini = new JPanel();
		mini.setBounds(50, 265, 680, 100);
		mini = getCampingCarTable(select1, where);

		scrollPane = new JScrollPane(dataTable);
		scrollPane.setPreferredSize(new Dimension(680, 100));
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
		mini.add(scrollPane);
		tempPanel.add(mini);

		// ------------------------------------------------------------panel2
		title1 = new JLabel("[CAMPING CAR COMPANY]");
		title1.setFont(new Font("Consolas", Font.BOLD, 16));
		title1.setBounds(10, 375, 300, 30);
		tempPanel.add(title1);

		lblSelect1 = new JLabel("SELECT");
		lblSelect1.setBounds(50, 395, 100, 30);
		tempPanel.add(lblSelect1);

		lblSelectTWO1 = new JLabel("SELECT");
		lblSelectTWO1.setBounds(194, 395, 100, 30);
		tempPanel.add(lblSelectTWO1);

		txtSelect1 = new JTextField(680);
		txtSelect1.setBounds(50, 425, 124, 30);
		tempPanel.add(txtSelect1);

		txtSelectTWO1 = new JTextField(680);
		txtSelectTWO1.setBounds(194, 425, 124, 30);
		tempPanel.add(txtSelectTWO1);

		lblWhere1 = new JLabel("WHERE");
		lblWhere1.setBounds(338, 395, 100, 30);
		tempPanel.add(lblWhere1);

		lblFrom1 = new JLabel("FROM");
		lblFrom1.setBounds(482, 395, 100, 30);
		tempPanel.add(lblFrom1);
		
		lblWhereTWO1 =new JLabel("WHERE");
		lblWhereTWO1.setBounds(626, 395, 100, 30);
		tempPanel.add(lblWhereTWO1);

		txtWhere1 = new JTextField(680);
		txtWhere1.setBounds(338, 425, 124, 30);
		tempPanel.add(txtWhere1);

		txtFrom1 = new JTextField(680);
		txtFrom1.setBounds(482, 425, 124, 30);
		tempPanel.add(txtFrom1);
		
		txtWhereTWO1=new JTextField(680);
		txtWhereTWO1.setBounds(626, 425, 124, 30);
		tempPanel.add(txtWhereTWO1);

		btnSelect1 = new JButton("SELECT");// ----------------
		btnSelect1.setBounds(220, 465, 100, 30);
		btnSelect1.addActionListener(this);
		tempPanel.add(btnSelect1);

		btnDelete1 = new JButton("DELETE");
		btnDelete1.setBounds(340, 465, 100, 30);
		btnDelete1.addActionListener(this);
		tempPanel.add(btnDelete1);

		btnUpdate1 = new JButton("UPDATE");
		btnUpdate1.setBounds(460, 465, 100, 30);
		btnUpdate1.addActionListener(this);
		tempPanel.add(btnUpdate1);

		lblInsert1 = new JLabel("INSERT");
		lblInsert1.setBounds(340, 490, 100, 30);
		tempPanel.add(lblInsert1);
		
		lblID1 = new JLabel("COMID");
		lblID1.setBounds(50, 520, 70, 30);
		tempPanel.add(lblID1);

		txtID1 = new JTextField(100);
		txtID1.setBounds(130, 520, 70, 30);
		txtID1.addActionListener(this);
		tempPanel.add(txtID1);

		lblAge1 = new JLabel("COMNAME");
		lblAge1.setBounds(210, 520, 70, 30);
		tempPanel.add(lblAge1);

		txtAge1 = new JTextField(100);
		txtAge1.setBounds(290, 520, 70, 30);
		txtAge1.addActionListener(this);
		tempPanel.add(txtAge1);

		lblRank1 = new JLabel("ADDR");
		lblRank1.setBounds(370, 520, 70, 30);
		tempPanel.add(lblRank1);

		txtRank1 = new JTextField(100);
		txtRank1.setBounds(450, 520, 70, 30);
		txtRank1.addActionListener(this);
		tempPanel.add(txtRank1);

		lblJob1 = new JLabel("TEL");
		lblJob1.setBounds(530, 520, 70, 30);
		tempPanel.add(lblJob1);

		txtJob1 = new JTextField(100);
		txtJob1.setBounds(610, 520, 70, 30);
		txtJob1.addActionListener(this);
		tempPanel.add(txtJob1);

		lblReserve1 = new JLabel("CHARGENAME");
		lblReserve1.setBounds(50, 550, 70, 30);
		tempPanel.add(lblReserve1);

		txtReserve1 = new JTextField(100);
		txtReserve1.setBounds(130, 550, 70, 30);
		txtReserve1.addActionListener(this);
		tempPanel.add(txtReserve1);

		lblSix1 = new JLabel("CHARGEEMAIL");
		lblSix1.setBounds(210, 550, 70, 30);
		tempPanel.add(lblSix1);

		txtSix1 = new JTextField(100);
		txtSix1.setBounds(290, 550, 70, 30);
		txtSix1.addActionListener(this);
		tempPanel.add(txtSix1);

		btnInsert1 = new JButton("INSERT");
		btnInsert1.setBounds(340, 605, 100, 30);
		btnInsert1.addActionListener(this);
		tempPanel.add(btnInsert1);

		model1 = new DefaultTableModel();
		dataTable1 = new JTable();
		dataTable1.setModel(model1);
		dataTable1.setPreferredScrollableViewportSize(dataTable1.getPreferredSize());

		dataTable1.setFillsViewportHeight(true);
		dataTable1.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable1.setRowHeight(20);
		dataTable1.getTableHeader().setReorderingAllowed(false);
		tempPanel.add(dataTable1);

		mini1 = new JPanel();
		mini1 = getCampingCarCompanyTable(select1, where);
		mini1.setBounds(50, 645, 680, 100);
		tempPanel.add(mini1);

		scrollPane1 = new JScrollPane(dataTable1);
		scrollPane1.setPreferredSize(new Dimension(680, 100));
		scrollPane1.getVerticalScrollBar().setValue(scrollPane1.getVerticalScrollBar().getMaximum());
		mini1.add(scrollPane1);

		// repair shop------------------------------------------------------------------------
		title2 = new JLabel("[REPAIR SHOP]");
		title2.setBounds(10, 765, 300, 30);
		title2.setFont(new Font("Consolas", Font.BOLD, 16));
		tempPanel.add(title2);

		lblSelect2 = new JLabel("SELECT");
		lblSelect2.setBounds(50, 795, 100, 30);
		tempPanel.add(lblSelect2);

		lblSelectTWO2 = new JLabel("SELECT");
		lblSelectTWO2.setBounds(194, 795, 100, 30);
		tempPanel.add(lblSelectTWO2);

		txtSelect2 = new JTextField(680);
		txtSelect2.setBounds(50, 825, 124, 30);
		tempPanel.add(txtSelect2);

		txtSelectTWO2 = new JTextField(680);
		txtSelectTWO2.setBounds(194, 825, 124, 30);
		tempPanel.add(txtSelectTWO2);

		lblWhere2 = new JLabel("WHERE");
		lblWhere2.setBounds(338, 795, 100, 30);
		tempPanel.add(lblWhere2);

		lblFrom2 = new JLabel("FROM");
		lblFrom2.setBounds(482, 795, 100, 30);
		tempPanel.add(lblFrom2);
		
		lblWhereTWO2 =new JLabel("WHERE");
		lblWhereTWO2.setBounds(626, 795, 100, 30);
		tempPanel.add(lblWhereTWO2);

		txtWhere2 = new JTextField(680);
		txtWhere2.setBounds(338, 825, 124, 30);
		tempPanel.add(txtWhere2);

		txtFrom2 = new JTextField(680);
		txtFrom2.setBounds(482, 825, 124, 30);
		tempPanel.add(txtFrom2);
		
		txtWhereTWO2=new JTextField(680);
		txtWhereTWO2.setBounds(626, 825, 124, 30);
		tempPanel.add(txtWhereTWO2);

		btnSelect2 = new JButton("SELECT");// ----------------
		btnSelect2.setBounds(220, 865, 100, 30);
		btnSelect2.addActionListener(this);
		tempPanel.add(btnSelect2);

		btnDelete2 = new JButton("DELETE");
		btnDelete2.setBounds(340, 865, 100, 30);
		btnDelete2.addActionListener(this);
		tempPanel.add(btnDelete2);

		btnUpdate2 = new JButton("UPDATE");
		btnUpdate2.setBounds(460, 865, 100, 30);
		btnUpdate2.addActionListener(this);
		tempPanel.add(btnUpdate2);

		lblInsert2 = new JLabel("INSERT");
		lblInsert2.setBounds(50, 890, 100, 30);
		tempPanel.add(lblInsert2);
		
		lblID2 = new JLabel("SHOPID");
		lblID2.setBounds(50, 920, 70, 30);
		tempPanel.add(lblID2);

		txtID2 = new JTextField(100);
		txtID2.setBounds(130, 920, 70, 30);
		txtID2.addActionListener(this);
		tempPanel.add(txtID2);

		lblAge2 = new JLabel("SHOPNAME");
		lblAge2.setBounds(210, 920, 70, 30);
		tempPanel.add(lblAge2);

		txtAge2 = new JTextField(100);
		txtAge2.setBounds(290, 920, 70, 30);
		txtAge2.addActionListener(this);
		tempPanel.add(txtAge2);

		lblRank2 = new JLabel("SHOPADDR");
		lblRank2.setBounds(370, 920, 70, 30);
		tempPanel.add(lblRank2);

		txtRank2 = new JTextField(100);
		txtRank2.setBounds(450, 920, 70, 30);
		txtRank2.addActionListener(this);
		tempPanel.add(txtRank2);

		lblJob2 = new JLabel("SHOPTEL");
		lblJob2.setBounds(530, 920, 70, 30);
		tempPanel.add(lblJob2);

		txtJob2 = new JTextField(100);
		txtJob2.setBounds(610, 920, 70, 30);
		txtJob2.addActionListener(this);
		tempPanel.add(txtJob2);

		lblReserve2 = new JLabel("SHOPCHARGENAME");
		lblReserve2.setBounds(50, 950, 70, 30);
		tempPanel.add(lblReserve2);

		txtReserve2 = new JTextField(100);
		txtReserve2.setBounds(130, 950, 70, 30);
		txtReserve2.addActionListener(this);
		tempPanel.add(txtReserve2);

		lblSix2 = new JLabel("SHOPCHARGEEMAIL");
		lblSix2.setBounds(210, 950, 70, 30);
		tempPanel.add(lblSix2);

		txtSix2 = new JTextField(100);
		txtSix2.setBounds(290, 950, 70, 30);
		txtSix2.addActionListener(this);
		tempPanel.add(txtSix2);

		btnInsert2 = new JButton("INSERT");
		btnInsert2.setBounds(340, 1005, 100, 30);
		btnInsert2.addActionListener(this);
		tempPanel.add(btnInsert2);

		model2 = new DefaultTableModel();
		dataTable2 = new JTable();
		dataTable2.setModel(model2);
		dataTable2.setPreferredScrollableViewportSize(dataTable2.getPreferredSize());

		dataTable2.setFillsViewportHeight(true);
		dataTable2.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable2.setRowHeight(20);
		dataTable2.getTableHeader().setReorderingAllowed(false);

		mini2 = new JPanel();
		mini2 = getRepairShopTable(select1, where);
		mini2.setBounds(50, 1045, 680, 100);
		tempPanel.add(mini2);

		scrollPane2 = new JScrollPane(dataTable2);
		scrollPane2.setPreferredSize(new Dimension(680, 100));
		scrollPane2.getVerticalScrollBar().setValue(scrollPane2.getVerticalScrollBar().getMaximum());
		mini1.add(scrollPane2);
		
		// Customer-----------------------------------------------------------------
		title3 = new JLabel("[CUSTOMER]");
		title3.setFont(new Font("Consolas", Font.BOLD, 16));
		title3.setBounds(760, 5, 300, 30);
		tempPanel.add(title3);

		lblSelect3 = new JLabel("SELECT");
		lblSelect3.setBounds(800, 20, 124, 30);
		tempPanel.add(lblSelect3);

		lblSelectTWO3 = new JLabel("SELECT");
		lblSelectTWO3.setBounds(944, 20, 124, 30);
		tempPanel.add(lblSelectTWO3);

		txtSelect3 = new JTextField(680);
		txtSelect3.setBounds(800, 50, 124, 30);
		tempPanel.add(txtSelect3);

		txtSelectTWO3 = new JTextField(680);
		txtSelectTWO3.setBounds(944, 50, 124, 30);
		tempPanel.add(txtSelectTWO3);

		lblWhere3 = new JLabel("WHERE");
		lblWhere3.setBounds(1088, 20, 124, 30);
		tempPanel.add(lblWhere3);

		lblFrom3 = new JLabel("FROM");
		lblFrom3.setBounds(1232, 20, 124, 30);
		tempPanel.add(lblFrom3);
		
		lblWhereTWO3 =new JLabel("WHERE");
		lblWhereTWO3.setBounds(1376, 20, 124, 30);
		tempPanel.add(lblWhereTWO3);

		txtWhere3 = new JTextField(680);
		txtWhere3.setBounds(1088, 50, 124, 30);
		tempPanel.add(txtWhere3);

		txtFrom3 = new JTextField(680);
		txtFrom3.setBounds(1232, 50, 124, 30);
		tempPanel.add(txtFrom3);
		
		txtWhereTWO3=new JTextField(680);
		txtWhereTWO3.setBounds(1376, 50, 124, 30);
		tempPanel.add(txtWhereTWO3);

		btnSelect3 = new JButton("SELECT");// ----------------
		btnSelect3.setBounds(970, 90, 100, 30);
		btnSelect3.addActionListener(this);
		tempPanel.add(btnSelect3);

		btnDelete3 = new JButton("DELETE");
		btnDelete3.setBounds(1090, 90, 100, 30);
		btnDelete3.addActionListener(this);
		tempPanel.add(btnDelete3);

		btnUpdate3 = new JButton("UPDATE");
		btnUpdate3.setBounds(1210, 90, 100, 30);
		btnUpdate3.addActionListener(this);
		tempPanel.add(btnUpdate3);

		lblInsert3 = new JLabel("INSERT");
		lblInsert3.setBounds(800, 120, 100, 30);
		tempPanel.add(lblInsert3);
		
		lblID3 = new JLabel("CUSLICENCE");
		lblID3.setBounds(800, 150, 70, 30);
		tempPanel.add(lblID3);

		txtID3 = new JTextField(100);
		txtID3.setBounds(880, 150, 70, 30);
		txtID3.addActionListener(this);
		tempPanel.add(txtID3);

		lblAge3 = new JLabel("CUSNAME");
		lblAge3.setBounds(960, 150, 70, 30);
		tempPanel.add(lblAge3);

		txtAge3 = new JTextField(100);
		txtAge3.setBounds(1040, 150, 70, 30);
		txtAge3.addActionListener(this);
		tempPanel.add(txtAge3);

		lblRank3 = new JLabel("CUSADDR");
		lblRank3.setBounds(1120, 150, 70, 30);
		tempPanel.add(lblRank3);

		txtRank3 = new JTextField(100);
		txtRank3.setBounds(1200, 150, 70, 30);
		txtRank3.addActionListener(this);
		tempPanel.add(txtRank3);

		lblJob3 = new JLabel("CUSTEL");
		lblJob3.setBounds(1280, 150, 70, 30);
		tempPanel.add(lblJob3);

		txtJob3 = new JTextField(100);
		txtJob3.setBounds(1360, 150, 70, 30);
		txtJob3.addActionListener(this);
		tempPanel.add(txtJob3);

		lblReserve3 = new JLabel("CUSEMAIL");
		lblReserve3.setBounds(800, 180, 70, 30);
		tempPanel.add(lblReserve3);

		txtReserve3 = new JTextField(100);
		txtReserve3.setBounds(880, 180, 70, 30);
		txtReserve3.addActionListener(this);
		tempPanel.add(txtReserve3);

		lblSeven3 = new JLabel("CUSPREVDATE");
		lblSeven3.setBounds(960, 180, 70, 30);
		tempPanel.add(lblSeven3);

		txtSeven3 = new JTextField(100);
		txtSeven3.setBounds(1040, 180, 70, 30);
		txtSeven3.addActionListener(this);
		tempPanel.add(txtSeven3);

		lblEight3 = new JLabel("CUSPREVSORT");
		lblEight3.setBounds(1120, 180, 70, 30);
		tempPanel.add(lblEight3);

		txtEight3 = new JTextField(100);
		txtEight3.setBounds(1200, 180, 70, 30);
		txtEight3.addActionListener(this);
		tempPanel.add(txtEight3);

		btnInsert3 = new JButton("INSERT");
		btnInsert3.setBounds(1090, 225, 100, 30);
		btnInsert3.addActionListener(this);
		tempPanel.add(btnInsert3);

		model3 = new DefaultTableModel();
		dataTable3 = new JTable();
		dataTable3.setModel(model3);
		dataTable3.setPreferredScrollableViewportSize(dataTable3.getPreferredSize());

		dataTable3.setFillsViewportHeight(true);
		dataTable3.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable3.setRowHeight(20);
		dataTable3.getTableHeader().setReorderingAllowed(false);

		mini3 = new JPanel();
		mini3.setBounds(800, 265, 680, 100);
		mini3 = getCustomerTable(select1, where);
		tempPanel.add(mini3);

		scrollPane3 = new JScrollPane(dataTable3);
		scrollPane3.setPreferredSize(new Dimension(680, 100));

		scrollPane3.setBackground(Color.yellow);
		scrollPane3.getVerticalScrollBar().setValue(scrollPane3.getVerticalScrollBar().getMaximum());
		mini3.add(scrollPane3);
		
		// RENT----------------------------------------------------
		title4 = new JLabel("[RENT]");
		title4.setBounds(760, 375, 300, 30);
		title4.setFont(new Font("Consolas", Font.BOLD, 16));
		tempPanel.add(title4);

		lblSelect4 = new JLabel("SELECT");
		lblSelect4.setBounds(800, 395, 124, 30);
		tempPanel.add(lblSelect4);

		lblSelectTWO4 = new JLabel("SELECT");
		lblSelectTWO4.setBounds(944, 395, 124, 30);
		tempPanel.add(lblSelectTWO4);

		txtSelect4 = new JTextField(680);
		txtSelect4.setBounds(800, 425, 124, 30);
		tempPanel.add(txtSelect4);

		txtSelectTWO4 = new JTextField(680);
		txtSelectTWO4.setBounds(944, 425, 124, 30);
		tempPanel.add(txtSelectTWO4);

		lblWhere4 = new JLabel("WHERE");
		lblWhere4.setBounds(1088, 395, 124, 30);
		tempPanel.add(lblWhere4);

		lblFrom4 = new JLabel("FROM");
		lblFrom4.setBounds(1232, 395, 124, 30);
		tempPanel.add(lblFrom4);
		
		lblWhereTWO4 =new JLabel("WHERE");
		lblWhereTWO4.setBounds(1376, 395, 124, 30);
		tempPanel.add(lblWhereTWO4);

		txtWhere4 = new JTextField(680);
		txtWhere4.setBounds(1088, 425, 124, 30);
		tempPanel.add(txtWhere4);

		txtFrom4 = new JTextField(680);
		txtFrom4.setBounds(1232, 425, 124, 30);
		tempPanel.add(txtFrom4);
		
		txtWhereTWO4=new JTextField(680);
		txtWhereTWO4.setBounds(1376, 425, 124, 30);
		tempPanel.add(txtWhereTWO4);

		btnSelect4 = new JButton("SELECT");// ----------------
		btnSelect4.setBounds(970, 465, 100, 30);
		btnSelect4.addActionListener(this);
		tempPanel.add(btnSelect4);

		btnDelete4 = new JButton("DELETE");
		btnDelete4.setBounds(1090, 465, 100, 30);
		btnDelete4.addActionListener(this);
		tempPanel.add(btnDelete4);

		btnUpdate4 = new JButton("UPDATE");
		btnUpdate4.setBounds(1210, 465, 100, 30);
		btnUpdate4.addActionListener(this);
		tempPanel.add(btnUpdate4);

		lblInsert4 = new JLabel("INSERT");
		lblInsert4.setBounds(800, 490, 100, 30);
		tempPanel.add(lblInsert4);
		
		lblID4 = new JLabel("RENTID");
		lblID4.setBounds(800, 520, 70, 30);
		tempPanel.add(lblID4);

		txtID4 = new JTextField(100);
		txtID4.setBounds(880, 520, 70, 30);
		txtID4.addActionListener(this);
		tempPanel.add(txtID4);

		lblAge4 = new JLabel("CARID");
		lblAge4.setBounds(960, 520, 70, 30);
		tempPanel.add(lblAge4);

		txtAge4 = new JTextField(100);
		txtAge4.setBounds(1040, 520, 70, 30);
		txtAge4.addActionListener(this);
		tempPanel.add(txtAge4);

		lblRank4 = new JLabel("COMPANYID");
		lblRank4.setBounds(1120, 520, 70, 30);
		tempPanel.add(lblRank4);

		txtRank4 = new JTextField(100);
		txtRank4.setBounds(1200, 520, 70, 30);
		txtRank4.addActionListener(this);
		tempPanel.add(txtRank4);

		lblJob4 = new JLabel("CUSLICENCE");
		lblJob4.setBounds(1280, 520, 70, 30);
		tempPanel.add(lblJob4);

		txtJob4 = new JTextField(100);
		txtJob4.setBounds(1360, 520, 70, 30);
		txtJob4.addActionListener(this);
		tempPanel.add(txtJob4);

		lblReserve4 = new JLabel("STARTDATE");
		lblReserve4.setBounds(800, 550, 70, 30);
		tempPanel.add(lblReserve4);

		txtReserve4 = new JTextField(100);
		txtReserve4.setBounds(880, 550, 70, 30);
		txtReserve4.addActionListener(this);
		tempPanel.add(txtReserve4);

		lblSeven4 = new JLabel("RENTPAYMENTDUE");
		lblSeven4.setBounds(960, 550, 70, 30);
		tempPanel.add(lblSeven4);

		txtSeven4 = new JTextField(100);
		txtSeven4.setBounds(1040, 550, 70, 30);
		txtSeven4.addActionListener(this);
		tempPanel.add(txtSeven4);

		lblEight4 = new JLabel("RENTPERIOD");
		lblEight4.setBounds(1120, 550, 70, 30);
		tempPanel.add(lblEight4);

		txtEight4 = new JTextField(100);
		txtEight4.setBounds(1200, 550, 70, 30);
		txtEight4.addActionListener(this);
		tempPanel.add(txtEight4);

		lblSix4 = new JLabel("RENTCOSTS");
		lblSix4.setBounds(1280, 550, 70, 30);
		tempPanel.add(lblSix4);

		txtSix4 = new JTextField(100);
		txtSix4.setBounds(1360, 550, 70, 30);
		txtSix4.addActionListener(this);
		tempPanel.add(txtSix4);

		btnInsert4 = new JButton("INSERT");
		btnInsert4.setBounds(1090, 605, 100, 30);
		btnInsert4.addActionListener(this);
		tempPanel.add(btnInsert4);

		model4 = new DefaultTableModel();
		dataTable4 = new JTable();
		dataTable4.setModel(model4);
		dataTable4.setPreferredScrollableViewportSize(dataTable4.getPreferredSize());

		dataTable4.setFillsViewportHeight(true);
		dataTable4.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable4.setRowHeight(20);
		dataTable4.getTableHeader().setReorderingAllowed(false);

		mini4 = new JPanel();
		mini4.setBounds(800, 645, 680, 100);
		mini4 = getRentTable(select1, where);
		tempPanel.add(mini4);

		scrollPane4 = new JScrollPane(dataTable4);
		scrollPane4.setPreferredSize(new Dimension(680, 100));
		scrollPane4.getVerticalScrollBar().setValue(scrollPane4.getVerticalScrollBar().getMaximum());
		mini4.add(scrollPane4);
		
		// REPAIR--------------------------------------------------
		title5 = new JLabel("[REPAIR]");
		title5.setBounds(760, 765, 300, 30);
		title5.setFont(new Font("Consolas", Font.BOLD, 16));
		tempPanel.add(title5);

		lblSelect5 = new JLabel("SELECT");
		lblSelect5.setBounds(800, 795, 124, 30);
		tempPanel.add(lblSelect5);

		lblSelectTWO5 = new JLabel("SELECT");
		lblSelectTWO5.setBounds(944, 795, 124, 30);
		tempPanel.add(lblSelectTWO5);

		txtSelect5 = new JTextField(680);
		txtSelect5.setBounds(800, 825, 124, 30);
		tempPanel.add(txtSelect5);

		txtSelectTWO5 = new JTextField(680);
		txtSelectTWO5.setBounds(944, 825, 124, 30);
		tempPanel.add(txtSelectTWO5);

		lblWhere5 = new JLabel("WHERE");
		lblWhere5.setBounds(1088, 795, 124, 30);
		tempPanel.add(lblWhere5);

		lblFrom5 = new JLabel("FROM");
		lblFrom5.setBounds(1232, 795, 124, 30);
		tempPanel.add(lblFrom5);
		
		lblWhereTWO5 =new JLabel("WHERE");
		lblWhereTWO5.setBounds(1376, 795, 124, 30);
		tempPanel.add(lblWhereTWO5);

		txtWhere5 = new JTextField(680);
		txtWhere5.setBounds(1088, 825, 124, 30);
		tempPanel.add(txtWhere5);

		txtFrom5 = new JTextField(680);
		txtFrom5.setBounds(1232, 825, 124, 30);
		tempPanel.add(txtFrom5);
		
		txtWhereTWO5=new JTextField(680);
		txtWhereTWO5.setBounds(1376, 825, 124, 30);
		tempPanel.add(txtWhereTWO5);

		btnSelect5 = new JButton("SELECT");// ----------------
		btnSelect5.setBounds(970, 865, 100, 30);
		btnSelect5.addActionListener(this);
		tempPanel.add(btnSelect5);

		btnDelete5 = new JButton("DELETE");
		btnDelete5.setBounds(1090, 865, 100, 30);
		btnDelete5.addActionListener(this);
		tempPanel.add(btnDelete5);

		btnUpdate5 = new JButton("UPDATE");
		btnUpdate5.setBounds(1210, 865, 100, 30);
		btnUpdate5.addActionListener(this);
		tempPanel.add(btnUpdate5);

		lblInsert5 = new JLabel("INSERT");
		lblInsert5.setBounds(800, 890, 100, 30);
		tempPanel.add(lblInsert5);

		lblID5 = new JLabel("REPAIRID");
		lblID5.setBounds(800, 920, 70, 30);
		tempPanel.add(lblID5);

		txtID5 = new JTextField(100);
		txtID5.setBounds(880, 920, 70, 30);
		txtID5.addActionListener(this);
		tempPanel.add(txtID5);

		lblAge5 = new JLabel("CARID");
		lblAge5.setBounds(960, 920, 70, 30);
		tempPanel.add(lblAge5);

		txtAge5 = new JTextField(100);
		txtAge5.setBounds(1040, 920, 70, 30);
		txtAge5.addActionListener(this);
		tempPanel.add(txtAge5);

		lblRank5 = new JLabel("SHOPID");
		lblRank5.setBounds(1120, 920, 70, 30);
		tempPanel.add(lblRank5);

		txtRank5 = new JTextField(100);
		txtRank5.setBounds(1200, 920, 70, 30);
		txtRank5.addActionListener(this);
		tempPanel.add(txtRank5);

		lblJob5 = new JLabel("COMPANYID");
		lblJob5.setBounds(1280, 920, 70, 30);
		tempPanel.add(lblJob5);

		txtJob5 = new JTextField(100);
		txtJob5.setBounds(1360, 920, 70, 30);
		txtJob5.addActionListener(this);
		tempPanel.add(txtJob5);

		lblReserve5 = new JLabel("CUSLICENCE");
		lblReserve5.setBounds(800, 950, 60, 30);
		tempPanel.add(lblReserve5);

		txtReserve5 = new JTextField(100);
		txtReserve5.setBounds(880, 950, 70, 30);
		txtReserve5.addActionListener(this);
		tempPanel.add(txtReserve5);

		lblSix5 = new JLabel("REPAIRDATE");
		lblSix5.setBounds(960, 950, 70, 30);
		tempPanel.add(lblSix5);

		txtSix5 = new JTextField(100);
		txtSix5.setBounds(1040, 950, 70, 30);
		txtSix5.addActionListener(this);
		tempPanel.add(txtSix5);

		lblSeven5 = new JLabel("REPAIRCOST");
		lblSeven5.setBounds(1120, 950, 70, 30);
		tempPanel.add(lblSeven5);

		txtSeven5 = new JTextField(100);
		txtSeven5.setBounds(1200, 950, 70, 30);
		txtSeven5.addActionListener(this);
		tempPanel.add(txtSeven5);

		btnInsert5 = new JButton("INSERT");
		btnInsert5.setBounds(1090, 1005, 100, 30);
		btnInsert5.addActionListener(this);
		tempPanel.add(btnInsert5);

		model5 = new DefaultTableModel();
		dataTable5 = new JTable();
		dataTable5.setModel(model5);
		dataTable5.setPreferredScrollableViewportSize(dataTable5.getPreferredSize());

		dataTable5.setFillsViewportHeight(true);
		dataTable5.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable5.setRowHeight(20);
		dataTable5.getTableHeader().setReorderingAllowed(false);

		mini5 = new JPanel();
		mini5 = getRepairTable(select1, where);
		mini5.setBounds(800, 1045, 680, 100);
		tempPanel.add(mini5);

		scrollPane5 = new JScrollPane(dataTable5);
		scrollPane5.setPreferredSize(new Dimension(680, 100));
		scrollPane5.getVerticalScrollBar().setValue(scrollPane5.getVerticalScrollBar().getMaximum());
		mini5.add(scrollPane5);
		
		//searchPanel
		searchPanel = new JPanel();
		searchField = new JTextField(600);
		searchButt = new JButton("SEARCH");
		searchMini = new JPanel();
		searchLbl = new JLabel("ENTER SEARCH");

		groupSelect = new JLabel("SELECT");
		groupFrom = new JLabel("FROM");
		groupGroupby = new JLabel("GROUP BY");
		groupHaving = new JLabel("HAVING");
		txtGroupSelect = new JTextField(600);
		txtGroupFrom = new JTextField(600);
		txtGroupGroupby = new JTextField(600);
		txtGroupHaving = new JTextField(600);
		btnGroupSelect = new JButton("ENTER");

		searchPanel.setBounds(50, 50, 700, 700);
		searchPanel.setBackground(new java.awt.Color(118, 168, 114));
		searchPanel.setLayout(null);

		groupSelect.setBounds(50, 100, 150, 30);
		groupSelect.setFont(new Font("Consolas", Font.BOLD, 20));
		searchPanel.add(groupSelect);

		txtGroupSelect.setBounds(350, 100, 200, 30);
		searchPanel.add(txtGroupSelect);

		groupFrom.setBounds(50, 150, 150, 30);
		groupFrom.setFont(new Font("Consolas", Font.BOLD, 20));
		searchPanel.add(groupFrom);

		txtGroupFrom.setBounds(350, 150, 200, 30);
		searchPanel.add(txtGroupFrom);

		groupGroupby.setBounds(50, 200, 150, 30);
		groupGroupby.setFont(new Font("Consolas", Font.BOLD, 20));
		searchPanel.add(groupGroupby);

		txtGroupGroupby.setBounds(350, 200, 200, 30);
		searchPanel.add(txtGroupGroupby);

		groupHaving.setBounds(50, 250, 150, 30);
		groupHaving.setFont(new Font("Consolas", Font.BOLD, 20));
		searchPanel.add(groupHaving);

		txtGroupHaving.setBounds(350, 250, 200, 30);
		searchPanel.add(txtGroupHaving);

		btnGroupSelect.setBounds(200, 300, 100, 30);
		btnGroupSelect.addActionListener(this);
		searchPanel.add(btnGroupSelect);

		model = new DefaultTableModel();
		dataTable = new JTable();
		dataTable.setPreferredScrollableViewportSize(dataTable.getPreferredSize());

		dataTable.setFillsViewportHeight(true);
		dataTable.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable.setRowHeight(20);
		dataTable.getTableHeader().setReorderingAllowed(false);

		searchMini = new JPanel();
		searchMini.setBounds(50, 360, 680, 200);
		searchMini = getCampingCarTable(select1, where);

		scrollPane = new JScrollPane(dataTable);
		scrollPane.setPreferredSize(new Dimension(600, 200));
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
		searchMini.add(scrollPane);
		searchPanel.add(searchMini);
	
		add(searchPanel);
		
		//mainScrollPane = new JScrollPane(searchPanel);
		//mainScrollPane.setBounds(50, 50, 700, 700);
		//add(mainScrollPane);

		searchPanel.setVisible(false);
	} // AppMainPanel()
	
	// getTable
	private JPanel getCampingCarTable(String select, String where) {
		JPanel jPanel = new JPanel();
		DefaultTableModel model = new DefaultTableModel();

		ArrayList<DescribeTableVO> arrDescribeTableVO = dbConnect.getTableDescription(tableName[0]);
		Object[] columnsName = new Object[arrDescribeTableVO.size()];
		for (int i = 0; i < arrDescribeTableVO.size(); i++) {
			columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
		}
		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[arrDescribeTableVO.size()];
		ArrayList<CampingCarVO> arrCampingCarVO = dbConnect.selectCampingCar(select, where);
		for (int i = 0; i < arrCampingCarVO.size(); i++) {
			rowData[0] = arrCampingCarVO.get(i).getCarID();
			rowData[1] = arrCampingCarVO.get(i).getCarNo();
			rowData[2] = arrCampingCarVO.get(i).getCarName();
			rowData[3] = arrCampingCarVO.get(i).getPassengerNo();
			rowData[4] = arrCampingCarVO.get(i).getCarCost();
			rowData[5] = arrCampingCarVO.get(i).getCompanyID();
			rowData[6] = arrCampingCarVO.get(i).getRegistrationDate();

			model.addRow(rowData);
		}

		dataTable.setModel(model);
		dataTable.setPreferredScrollableViewportSize(dataTable.getPreferredSize());
		dataTable.setFillsViewportHeight(true);
		dataTable.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable.setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable.setRowHeight(20);
		dataTable.getTableHeader().setReorderingAllowed(false);

		scrollPane = new JScrollPane(dataTable);
		scrollPane.setPreferredSize(new Dimension(680, 100));

		jPanel.add(scrollPane);

		return jPanel;
	}

	private JPanel getCampingCarCompanyTable(String select, String where) {
		JPanel jPanel = new JPanel();
		DefaultTableModel model = new DefaultTableModel();

		ArrayList<DescribeTableVO> arrDescribeTableVO = dbConnect.getTableDescription(tableName[1]);
		Object[] columnsName = new Object[arrDescribeTableVO.size()];
		for (int i = 0; i < arrDescribeTableVO.size(); i++) {
			columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
		}
		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[arrDescribeTableVO.size()];
		ArrayList<CampingCarCompanyVO> arrCampingCarCompanyVO = dbConnect.selectCampingCarCompany(select, where);
		for (int i = 0; i < arrCampingCarCompanyVO.size(); i++) {
			rowData[0] = arrCampingCarCompanyVO.get(i).getCompanyID();
			rowData[1] = arrCampingCarCompanyVO.get(i).getComname();
			rowData[2] = arrCampingCarCompanyVO.get(i).getAddr();
			rowData[3] = arrCampingCarCompanyVO.get(i).getTel();
			rowData[4] = arrCampingCarCompanyVO.get(i).getChargeName();
			rowData[5] = arrCampingCarCompanyVO.get(i).getChargeEMail();

			model.addRow(rowData);
		}

		dataTable1.setModel(model);
		dataTable1.setPreferredScrollableViewportSize(dataTable.getPreferredSize());
		dataTable1.setFillsViewportHeight(true);
		dataTable1.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable1.setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable1.setRowHeight(20);
		dataTable1.getTableHeader().setReorderingAllowed(false);

		scrollPane1 = new JScrollPane(dataTable1);
		scrollPane1.setPreferredSize(new Dimension(680, 100));

		jPanel.add(scrollPane1);

		return jPanel;
	}

	private JPanel getRepairShopTable(String select, String where) {
		JPanel jPanel = new JPanel();
		DefaultTableModel model = new DefaultTableModel();

		ArrayList<DescribeTableVO> arrDescribeTableVO = dbConnect.getTableDescription(tableName[2]);
		Object[] columnsName = new Object[arrDescribeTableVO.size()];
		for (int i = 0; i < arrDescribeTableVO.size(); i++) {
			columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
		}
		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[arrDescribeTableVO.size()];
		ArrayList<RepairShopVO> arrRepairShopVO = dbConnect.selectRepairShop(select, where);
		for (int i = 0; i < arrRepairShopVO.size(); i++) {
			rowData[0] = arrRepairShopVO.get(i).getShopID();
			rowData[1] = arrRepairShopVO.get(i).getShopName();
			rowData[2] = arrRepairShopVO.get(i).getShopAddr();
			rowData[3] = arrRepairShopVO.get(i).getShopTel();
			rowData[4] = arrRepairShopVO.get(i).getShopChargeName();
			rowData[5] = arrRepairShopVO.get(i).getShopChargeEmail();

			model.addRow(rowData);
		}

		dataTable2.setModel(model);
		dataTable2.setPreferredScrollableViewportSize(dataTable.getPreferredSize());
		dataTable2.setFillsViewportHeight(true);
		dataTable2.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable2.setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable2.setRowHeight(20);
		dataTable2.getTableHeader().setReorderingAllowed(false);

		scrollPane2 = new JScrollPane(dataTable2);
		scrollPane2.setPreferredSize(new Dimension(680, 100));

		jPanel.add(scrollPane2);

		return jPanel;
	}

	private JPanel getCustomerTable(String select, String where) {
		JPanel jPanel = new JPanel();
		DefaultTableModel model = new DefaultTableModel();

		ArrayList<DescribeTableVO> arrDescribeTableVO = dbConnect.getTableDescription(tableName[3]);
		Object[] columnsName = new Object[arrDescribeTableVO.size()];
		for (int i = 0; i < arrDescribeTableVO.size(); i++) {
			columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
		}
		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[arrDescribeTableVO.size()];
		ArrayList<CustomerVO> arrCustomerVO = dbConnect.selectCustomer(select, where);
		for (int i = 0; i < arrCustomerVO.size(); i++) {
			rowData[0] = arrCustomerVO.get(i).getCusLicence();
			rowData[1] = arrCustomerVO.get(i).getCusName();
			rowData[2] = arrCustomerVO.get(i).getCusAddr();
			rowData[3] = arrCustomerVO.get(i).getCusTel();
			rowData[4] = arrCustomerVO.get(i).getCusEmail();
			rowData[5] = arrCustomerVO.get(i).getCusPrevDate();
			rowData[6] = arrCustomerVO.get(i).getCusPrevSort();

			model.addRow(rowData);
		}

		dataTable3.setModel(model);
		dataTable3.setPreferredScrollableViewportSize(dataTable.getPreferredSize());
		dataTable3.setFillsViewportHeight(true);
		dataTable3.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable3.setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable3.setRowHeight(20);
		dataTable3.getTableHeader().setReorderingAllowed(false);

		scrollPane3 = new JScrollPane(dataTable3);
		scrollPane3.setPreferredSize(new Dimension(680, 100));

		jPanel.add(scrollPane3);

		return jPanel;
	}

	private JPanel getRentTable(String select, String where) {
		JPanel jPanel = new JPanel();
		DefaultTableModel model = new DefaultTableModel();

		ArrayList<DescribeTableVO> arrDescribeTableVO = dbConnect.getTableDescription(tableName[4]);
		Object[] columnsName = new Object[arrDescribeTableVO.size()];
		for (int i = 0; i < arrDescribeTableVO.size(); i++) {
			columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
		}
		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[arrDescribeTableVO.size()];
		ArrayList<RentVO> arrRentVO = dbConnect.selectRent(select, where);

		for (int i = 0; i < arrRentVO.size(); i++) {
			rowData[0] = arrRentVO.get(i).getRentID();
			rowData[1] = arrRentVO.get(i).getCarID();
			rowData[2] = arrRentVO.get(i).getComID();
			rowData[3] = arrRentVO.get(i).getCusLicence();
			rowData[4] = arrRentVO.get(i).getStartDate();
			rowData[5] = arrRentVO.get(i).getRentPaymentDue();
			rowData[6] = arrRentVO.get(i).getRentPeriod();
			rowData[7] = arrRentVO.get(i).getRentCosts();
			model.addRow(rowData);
		}

		dataTable4.setModel(model);
		dataTable4.setPreferredScrollableViewportSize(dataTable.getPreferredSize());
		dataTable4.setFillsViewportHeight(true);
		dataTable4.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable4.setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable4.setRowHeight(20);
		dataTable4.getTableHeader().setReorderingAllowed(false);

		scrollPane4 = new JScrollPane(dataTable4);
		scrollPane4.setPreferredSize(new Dimension(680, 100));

		jPanel.add(scrollPane4);
		
		return jPanel;
	}

	private JPanel getRepairTable(String select, String where) {
		JPanel jPanel = new JPanel();
		DefaultTableModel model = new DefaultTableModel();

		ArrayList<DescribeTableVO> arrDescribeTableVO = dbConnect.getTableDescription(tableName[5]);
		Object[] columnsName = new Object[arrDescribeTableVO.size()];
		for (int i = 0; i < arrDescribeTableVO.size(); i++) {
			columnsName[i] = arrDescribeTableVO.get(i).getColumn_name();
		}
		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[arrDescribeTableVO.size()];
		ArrayList<RepairVO> arrRepairVO = dbConnect.selectRepair(select, where);
		for (int i = 0; i < arrRepairVO.size(); i++) {
			rowData[0] = arrRepairVO.get(i).getRepairID();
			rowData[1] = arrRepairVO.get(i).getCarID();
			rowData[2] = arrRepairVO.get(i).getShopID();
			rowData[3] = arrRepairVO.get(i).getComID();
			rowData[4] = arrRepairVO.get(i).getcusLicense();
			rowData[5] = arrRepairVO.get(i).getRepairDate();
			rowData[6] = arrRepairVO.get(i).getRepairCost();

			model.addRow(rowData);
		}

		dataTable5.setModel(model);
		dataTable5.setPreferredScrollableViewportSize(dataTable.getPreferredSize());
		dataTable5.setFillsViewportHeight(true);
		dataTable5.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable5.setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable5.setRowHeight(20);
		dataTable5.getTableHeader().setReorderingAllowed(false);

		scrollPane5 = new JScrollPane(dataTable5);
		scrollPane5.setPreferredSize(new Dimension(680, 100));

		jPanel.add(scrollPane5);

		return jPanel;
	}

	//getGroup
	private JPanel getGroupCampingCarTable(String select, String group, String having) {
		JPanel jPanel = new JPanel();
		DefaultTableModel model = new DefaultTableModel();

		Object[] columnsName = new Object[2];
		columnsName[0] = "PASSENGERNO";
		columnsName[1] = "COUNT(*)";
		model.setColumnIdentifiers(columnsName);
		
		Object[] rowData = new Object[2];
		ArrayList<groupCampingCarVO> arrGroupCampingCarVO = dbConnect.groupCampingCar(select, group, having);
		for (int i = 0; i < arrGroupCampingCarVO.size(); i++) {
			rowData[0] = arrGroupCampingCarVO.get(i).getPassengerNo();
			rowData[1] = arrGroupCampingCarVO.get(i).getCount();
			model.addRow(rowData);
		}
		
		dataTable = new JTable();
		dataTable.setModel(model);
		dataTable.setPreferredScrollableViewportSize(dataTable.getPreferredSize());
		dataTable.setFillsViewportHeight(true);
		dataTable.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable.setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable.setRowHeight(20);
		dataTable.getTableHeader().setReorderingAllowed(false);

		scrollPane = new JScrollPane(dataTable);
		scrollPane.setPreferredSize(new Dimension(600, 200));
		jPanel.add(scrollPane);

		return jPanel;
	}
	
	private JPanel getGroupRepairTable(String select, String group, String having) {
		JPanel jPanel = new JPanel();
		DefaultTableModel model = new DefaultTableModel();

		Object[] columnsName = new Object[2];
		columnsName[0] = "SHOPID";
		columnsName[1] = "COUNT(*)";
		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[2];
		ArrayList<groupRepairVO> arrGroupRepairVO = dbConnect.groupRepair(select, group, having);
		for (int i = 0; i < arrGroupRepairVO.size(); i++) {
			rowData[0] = arrGroupRepairVO.get(i).getShopID();
			rowData[1] = arrGroupRepairVO.get(i).getCount();
			model.addRow(rowData);
		}

		dataTable = new JTable();
		dataTable.setModel(model);
		dataTable.setPreferredScrollableViewportSize(dataTable.getPreferredSize());
		dataTable.setFillsViewportHeight(true);
		dataTable.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable.setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable.setRowHeight(20);
		dataTable.getTableHeader().setReorderingAllowed(false);

		scrollPane = new JScrollPane(dataTable);
		scrollPane.setPreferredSize(new Dimension(600, 200));

		jPanel.add(scrollPane);

		return jPanel;
	}
	

	//nested
	private JPanel getNest1(String select, String where, String select2, String from, String where2) {
		JPanel jPanel = new JPanel();
		DefaultTableModel model = new DefaultTableModel();

		Object[] columnsName = new Object[2];
		columnsName[0] = "CARID";
		columnsName[1] = "CARNO";
		model.setColumnIdentifiers(columnsName);
		
		Object[] rowData = new Object[2];
		ArrayList<nested1VO> arrNestVO = dbConnect.nested1(select, where, select2, from, where2);
		for (int i = 0; i < arrNestVO.size(); i++) {
			rowData[0] = arrNestVO.get(i).getCarID();
			rowData[1] = arrNestVO.get(i).getCarNo();
			model.addRow(rowData);
		}		
		dataTable = new JTable();
		dataTable.setModel(model);
		dataTable.setPreferredScrollableViewportSize(dataTable.getPreferredSize());
		dataTable.setFillsViewportHeight(true);
		dataTable.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable.setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable.setRowHeight(20);
		dataTable.getTableHeader().setReorderingAllowed(false);

		scrollPane = new JScrollPane(dataTable);
		scrollPane.setPreferredSize(new Dimension(680, 100));
		jPanel.add(scrollPane);
		
		return jPanel;
	}
	
	private JPanel getNest2(String select, String where, String select2, String from, String where2) {
		JPanel jPanel = new JPanel();
		DefaultTableModel model = new DefaultTableModel();

		Object[] columnsName = new Object[2];
		columnsName[0] = "REPAIRID";
		columnsName[1] = "COMPANYID";
		model.setColumnIdentifiers(columnsName);

		Object[] rowData = new Object[2];
		ArrayList<nested2VO> arrNestVO = dbConnect.nested2(select, where, select2, from, where2);
		for (int i = 0; i < arrNestVO.size(); i++) {
			rowData[0] = arrNestVO.get(i).getRepairID();
			rowData[1] = arrNestVO.get(i).getCompanyID();
			model.addRow(rowData);
		}

		dataTable = new JTable();
		dataTable.setModel(model);
		dataTable.setPreferredScrollableViewportSize(dataTable.getPreferredSize());
		dataTable.setFillsViewportHeight(true);
		dataTable.getTableHeader().setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable.setFont(new Font("Verdana", Font.PLAIN, 17));
		dataTable.setRowHeight(20);
		dataTable.getTableHeader().setReorderingAllowed(false);

		scrollPane = new JScrollPane(dataTable);
		scrollPane.setPreferredSize(new Dimension(680, 100));
		jPanel.add(scrollPane);
		
		return jPanel;
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		JButton b = (JButton) obj;

		if (obj == cmbMenu1) {
			tempPanel.setVisible(true);
			mainScrollPane.setVisible(true);
			tempPanel.setBackground(new java.awt.Color(103, 168, 198));
			String ans_str = (String) JOptionPane.showInputDialog(this, "PASSWORD", "CONFIRM MANAGER",
					JOptionPane.PLAIN_MESSAGE, null, null, null);
			if (ans_str.equals("1234")) {
				System.out.println("QUALIFIED");
				tempPanel.setVisible(true);

				btnDelete.setEnabled(true);
				btnUpdate.setEnabled(true);
				btnInsert.setEnabled(true);

				btnDelete1.setEnabled(true);
				btnUpdate1.setEnabled(true);
				btnInsert1.setEnabled(true);

				btnDelete2.setEnabled(true);
				btnUpdate2.setEnabled(true);
				btnInsert2.setEnabled(true);

				btnDelete4.setEnabled(true);
				btnUpdate4.setEnabled(true);
				btnInsert4.setEnabled(true);

				btnDelete5.setEnabled(true);
				btnUpdate5.setEnabled(true);
				btnInsert5.setEnabled(true);
			} else {
				System.out.println("UNQUALIFIED");
				JOptionPane.showMessageDialog(this, "Not Access", "ERROR", JOptionPane.ERROR_MESSAGE);
				tempPanel.setEnabled(false);
			}
		} else if (obj == cmbMenu2) {
			searchPanel.setVisible(false);
			tempPanel.setVisible(true);
			mainScrollPane.setVisible(true);
			tempPanel.setBackground(new java.awt.Color(221, 132, 124));
			tempPanel.setVisible(true);
			btnDelete.setEnabled(false);
			btnUpdate.setEnabled(false);
			btnInsert.setEnabled(false);

			btnDelete1.setEnabled(false);
			btnUpdate1.setEnabled(false);
			btnInsert1.setEnabled(false);

			btnDelete2.setEnabled(false);
			btnUpdate2.setEnabled(false);
			btnInsert2.setEnabled(false);

			btnDelete4.setEnabled(false);
			btnUpdate4.setEnabled(false);
			btnInsert4.setEnabled(false);

			btnDelete5.setEnabled(false);
			btnUpdate5.setEnabled(false);
			btnInsert5.setEnabled(false);
		} else if (obj == btnInit) {
			select1 = where = "";
			dbConnect.deleteDB();
			dbConnect.initDataBase();
			dbConnect.resetDB();

			tempPanel.remove(mini);
			mini = getCampingCarTable(select1, where);
			mini.setBounds(50, 265, 680, 100);
			tempPanel.add(mini);

			tempPanel.remove(mini1);
			mini1 = getCampingCarCompanyTable(select1, where);
			mini1.setBounds(50, 645, 680, 100);
			tempPanel.add(mini1);

			tempPanel.remove(mini2);
			mini2 = getRepairShopTable(select1, where);
			mini2.setBounds(50, 1045, 680, 100);
			tempPanel.add(mini2);

			tempPanel.remove(mini3);
			mini3 = getCustomerTable(select1, where);
			mini3.setBounds(800, 265, 680, 100);
			tempPanel.add(mini3);

			tempPanel.remove(mini4);
			mini4 = getRentTable(select1, where);
			mini4.setBounds(800, 645, 680, 100);
			tempPanel.add(mini4);

			tempPanel.remove(mini5);
			mini5 = getRepairTable(select1, where);
			mini5.setBounds(800, 1045, 680, 100);
			tempPanel.add(mini5);
		} else if (obj == btnJoinSearch) {
			tempPanel.setVisible(false);

			mainScrollPane.setVisible(false);
			searchPanel.setVisible(true);
		}

		String btnName = b.getText();

		switch (btnName) {
		case "SELECT":
			select1 = where = "";
			if (obj == btnSelect) {
				tempPanel.remove(mini);
				select1 = txtSelect.getText();
				where = txtWhere.getText();
				if (!(select2 = txtSelectTWO.getText()).equals("")) {
					from = txtFrom.getText();
					where2 = txtWhereTWO.getText();
					mini = getNest1(select1, where, select2, from, where2);
				}
				else mini = getCampingCarTable(select1, where);
				mini.setBounds(50, 265, 680, 100);
				tempPanel.add(mini);
			} else if (obj == btnSelect1) {
				select1 = txtSelect1.getText();
				where = txtWhere1.getText();

				tempPanel.remove(mini1);
				mini1 = getCampingCarCompanyTable(select1, where);
				mini1.setBounds(50, 645, 680, 100);
				tempPanel.add(mini1);
			} else if (obj == btnSelect2) {
				select1 = txtSelect2.getText();
				where = txtWhere2.getText();

				tempPanel.remove(mini2);
				mini2 = getRepairShopTable(select1, where);
				mini2.setBounds(50, 1045, 680, 100);
				tempPanel.add(mini2);
			} else if (obj == btnSelect3) {
				select1 = txtSelect3.getText();
				where = txtWhere3.getText();

				tempPanel.remove(mini3);
				mini3 = getCustomerTable(select1, where);
				mini3.setBounds(800, 265, 680, 100);
				tempPanel.add(mini3);
			} else if (obj == btnSelect4) {
				select1 = txtSelect4.getText();
				where = txtWhere4.getText();

				tempPanel.remove(mini4);
				mini4 = getRentTable(select1, where);
				mini4.setBounds(800, 645, 680, 100);
				tempPanel.add(mini4);
			} else if (obj == btnSelect5) {
				System.out.println("6");
				tempPanel.remove(mini5);
				
				select1 = txtSelect5.getText();
				where = txtWhere5.getText();
				if (!(select2 = txtSelectTWO5.getText()).equals("")) {
					from = txtFrom5.getText();
					where2 = txtWhereTWO5.getText();
					mini5 = getNest2(select1, where, select2, from, where2);
				}
				else mini5 = getRepairTable(select1, where);
				mini5.setBounds(800, 1045, 680, 100);
				tempPanel.add(mini5);
			}

			setVisible(true);
			validate();
			repaint();
			break;

		case "DELETE":
			select1 = where = "";
			if (obj == btnDelete) {
				where = "where " + txtWhere.getText();
				dbConnect.deleteCampingCar(where);

				tempPanel.remove(mini);
				mini = getCampingCarTable(select1, where);
				mini.setBounds(50, 265, 680, 100);
				tempPanel.add(mini);
			} else if (obj == btnDelete1) {
				where = "where " + txtWhere1.getText();
				dbConnect.deleteCampingCarCompany(where);

				tempPanel.remove(mini1);
				mini1 = getCampingCarCompanyTable(select1, where);
				mini1.setBounds(50, 645, 680, 100);
				tempPanel.add(mini1);
			} else if (obj == btnDelete2) {
				where = "where " + txtWhere2.getText();
				dbConnect.deleteRepairShop(where);

				tempPanel.remove(mini2);
				mini2 = getRepairShopTable(select1, where);
				mini2.setBounds(50, 1045, 680, 100);
				tempPanel.add(mini2);
			} else if (obj == btnDelete3) {
				where = "where " + txtWhere3.getText();
				dbConnect.deleteCustomer(where);

				tempPanel.remove(mini3);
				mini3 = getCustomerTable(select1, where);
				mini3.setBounds(800, 265, 680, 100);
				tempPanel.add(mini3);
			} else if (obj == btnDelete4) {
				where = "where " + txtWhere4.getText();
				dbConnect.deleteRent(where);

				tempPanel.remove(mini4);
				mini4 = getRentTable(select1, where);
				mini4.setBounds(800, 645, 680, 100);
				tempPanel.add(mini4);
			} else if (obj == btnDelete5) {
				where = "where " + txtWhere5.getText();
				dbConnect.deleteRepair(where);

				tempPanel.remove(mini5);
				mini5 = getRepairTable(select1, where);
				mini5.setBounds(800, 1045, 680, 100);
				tempPanel.add(mini5);
			}

		case "UPDATE":
			select1 = where = "";
			if (obj == btnUpdate) {
				select1 = txtSelect.getText();
				where = txtWhere.getText();
				dbConnect.updateCampingCar(select1, where);

				tempPanel.remove(mini);
				mini = getCampingCarTable(select1, where);
				mini.setBounds(50, 265, 680, 100);
				tempPanel.add(mini);
			} else if (obj == btnUpdate1) {
				select1 = txtSelect1.getText();
				where = txtWhere1.getText();
				dbConnect.updateCampingCarCompany(select1, where);

				tempPanel.remove(mini1);
				mini1 = getCampingCarCompanyTable(select1, where);
				mini1.setBounds(50, 645, 680, 100);
				tempPanel.add(mini1);
			} else if (obj == btnUpdate2) {
				select1 = txtSelect2.getText();
				where = txtWhere2.getText();
				dbConnect.updateRepairShop(select1, where);

				tempPanel.remove(mini2);
				mini2 = getRepairShopTable(select1, where);
				mini2.setBounds(50, 1045, 680, 100);
				tempPanel.add(mini2);
			} else if (obj == btnUpdate3) {
				select1 = txtSelect3.getText();
				where = txtWhere3.getText();
				dbConnect.updateCustomer(select1, where);

				tempPanel.remove(mini3);
				mini3 = getCustomerTable(select1, where);
				mini3.setBounds(800, 265, 680, 100);
				tempPanel.add(mini3);
			} else if (obj == btnUpdate4) {
				select1 = txtSelect4.getText();
				where = txtWhere4.getText();
				dbConnect.updateRent(select1, where);

				tempPanel.remove(mini4);
				mini4 = getRentTable(select1, where);
				mini4.setBounds(800, 645, 680, 100);
				tempPanel.add(mini4);
			} else if (obj == btnUpdate5) {
				select1 = txtSelect5.getText();
				where = txtWhere5.getText();
				dbConnect.updateRepair(select1, where);

				tempPanel.remove(mini5);
				mini5 = getRepairTable(select1, where);
				mini5.setBounds(800, 1045, 680, 100);
				tempPanel.add(mini5);
			}

		case "INSERT":
			select1 = where = "";
			if (obj == btnInsert) {
				dbConnect.insertCampingCar(txtID.getText(), txtAge.getText(), txtRank.getText(), txtJob.getText(),
						txtReserve.getText(), txtSix.getText(), txtSeven.getText());
			
				tempPanel.remove(mini);
				mini = getCampingCarTable(select1, where);
				mini.setBounds(50, 265, 680, 100);
				tempPanel.add(mini);
			} else if (obj == btnInsert1) {
				dbConnect.insertCampingCarCompany(txtID1.getText(), txtAge1.getText(), txtRank1.getText(),
						txtJob1.getText(), txtReserve1.getText(), txtSix1.getText());
				
				tempPanel.remove(mini1);
				mini1 = getCampingCarCompanyTable(select1, where);
				mini1.setBounds(50, 645, 680, 100);
				tempPanel.add(mini1);
			} else if (obj == btnInsert2) {
				dbConnect.insertRepairShop(txtID2.getText(), txtAge2.getText(), txtRank2.getText(), txtJob2.getText(),
						txtReserve2.getText(), txtSix2.getText());
				
				tempPanel.remove(mini2);
				mini2 = getRepairShopTable(select1, where);
				mini2.setBounds(50, 1045, 680, 100);
				tempPanel.add(mini2);
			} else if (obj == btnInsert3) {
				dbConnect.insertCustomer(txtID3.getText(), txtAge3.getText(), txtRank3.getText(), txtJob3.getText(),
						txtReserve3.getText(), txtSeven3.getText(), txtEight3.getText());
				
				tempPanel.remove(mini3);
				mini3 = getCustomerTable(select1, where);
				mini3.setBounds(800, 265, 680, 100);
				tempPanel.add(mini3);
			} else if (obj == btnInsert4) {
				dbConnect.insertRent(txtID4.getText(), txtAge4.getText(), txtRank4.getText(), txtJob4.getText(),
						txtReserve4.getText(), txtSeven4.getText(), txtEight4.getText(), txtSix4.getText());
				
				tempPanel.remove(mini4);
				mini4 = getRentTable(select1, where);
				mini4.setBounds(800, 645, 680, 100);
				tempPanel.add(mini4);
			} else if (obj == btnInsert5) {
				dbConnect.insertRepair(txtID5.getText(), txtAge5.getText(), txtRank5.getText(), txtJob5.getText(),
						txtReserve5.getText(), txtSix5.getText(), txtSeven5.getText());
				
				tempPanel.remove(mini5);
				mini5 = getRepairTable(select1, where);
				mini5.setBounds(800, 1045, 680, 100);
				tempPanel.add(mini5);
			}

			setVisible(true);
			validate();
			repaint();
			break;
		}

		if (obj == btnInsert || obj == btnInsert1 || obj == btnInsert2 || obj == btnInsert3 || obj == btnInsert4
				|| obj == btnInsert5) {
			txtID.setText("");
			txtAge.setText("");
			txtRank.setText("");
			txtJob.setText("");
			txtReserve.setText("");
			txtSix.setText("");
			txtSeven.setText("");

			txtID1.setText("");
			txtAge1.setText("");
			txtRank1.setText("");
			txtJob1.setText("");
			txtReserve1.setText("");
			txtSix1.setText("");

			txtID2.setText("");
			txtAge2.setText("");
			txtRank2.setText("");
			txtJob2.setText("");
			txtReserve2.setText("");
			txtSix2.setText("");

			txtID3.setText("");
			txtAge3.setText("");
			txtRank3.setText("");
			txtJob3.setText("");
			txtReserve3.setText("");
			txtSeven3.setText("");
			txtEight3.setText("");

			txtID4.setText("");
			txtAge4.setText("");
			txtRank4.setText("");
			txtJob4.setText("");
			txtReserve4.setText("");
			txtSix4.setText("");
			txtSeven4.setText("");
			txtEight4.setText("");

			txtID5.setText("");
			txtAge5.setText("");
			txtRank5.setText("");
			txtJob5.setText("");
			txtReserve5.setText("");
			txtSix5.setText("");
			txtSeven5.setText("");
		}
		if (obj == btnSelect || obj == btnSelect1 || obj == btnSelect2 || obj == btnSelect3 || obj == btnSelect4
				|| obj == btnSelect5 || obj == btnDelete || obj == btnDelete1 || obj == btnDelete2 || obj == btnDelete3
				|| obj == btnDelete4 || obj == btnDelete5 || obj == btnUpdate || obj == btnUpdate1 || obj == btnUpdate2
				|| obj == btnUpdate3 || obj == btnUpdate4 || obj == btnUpdate5) {
			txtSelect.setText("");
			txtWhere.setText("");

			txtSelect1.setText("");
			txtWhere1.setText("");

			txtSelect2.setText("");
			txtWhere2.setText("");

			txtSelect3.setText("");
			txtWhere3.setText("");

			txtSelect4.setText("");
			txtWhere4.setText("");

			txtSelect5.setText("");
			txtWhere5.setText("");
		}
		if(obj == btnGroupSelect){
			select1 = txtGroupSelect.getText();
			from = txtGroupFrom.getText();
			String group = txtGroupGroupby.getText();
			String having = txtGroupHaving.getText();
			
			searchPanel.remove(searchMini);
			if(from.toUpperCase().equals("CAMPINGCAR"))
				searchMini = getGroupCampingCarTable(select1, group, having);
			else if(from.toUpperCase().equals("REPAIR"))
				searchMini = getGroupRepairTable(select1, group, having);
			
			searchMini.setBounds(50, 360, 600, 200);
			searchPanel.add(searchMini);
		}
	}
}