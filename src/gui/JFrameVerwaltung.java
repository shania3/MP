package gui;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import Dao.VereinDao;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class JFrameVerwaltung extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton button_Abmelden;
	private JLabel labelHerzlichWillkommen;
	private JTable table;

	private JButton buttonAktualisieren;
	private JButton buttonSportartVerwalten;
	private JButton buttonMannschaftenVerwalten;
	private JPanel panel;
	private JButton buttonNewButton;
	private JButton btnNewButtonZeitblockaendern;
	private JLabel labelBild;
	private JButton buttonTrainingVerwalten;
	private JButton buttonNewMitgliederVerwalten;

	/**
	 * Launch the application.
	 */



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameVerwaltung frame = new JFrameVerwaltung();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameVerwaltung() {
		try {
			initGUI();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.setLocationRelativeTo(null);
	}
	
	private void initGUI() throws ClassNotFoundException, SQLException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\Mittelstufenprojekt\\sport.jpg"));
		setTitle("Sie sind angemeldet");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		{
			{
				panel = new JPanel();
				panel.setBorder(new TitledBorder(null, "Verwaltung", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				labelBild = new JLabel(new ImageIcon(JFrameVerwaltung.class.getResource("/gui/Unbenannt.png")));
				labelBild.setToolTipText("Sport");
				labelBild.setHorizontalAlignment(SwingConstants.CENTER);
				{
					button_Abmelden = new JButton("Abmelden");
					button_Abmelden.setVerifyInputWhenFocusTarget(false);
					button_Abmelden.setMnemonic('l');
					button_Abmelden.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							button_AbmeldenActionPerformed(e);
						}
					});
					button_Abmelden.setToolTipText("Hier koennen sie sich wieder abmelden");
				}
				{
					buttonAktualisieren = new JButton("Aktualisieren");
					buttonAktualisieren.setToolTipText("Wenn Sie hier klicken wird die Tabelle aktualisiert");
					{
						{
							buttonSportartVerwalten = new JButton("Sportarten verwalten");
							buttonSportartVerwalten.setToolTipText("Hier k\u00F6nnen Sie Sportarten anzeigen lassen, hinzuf\u00FCgen, \u00E4ndern und l\u00F6schen.");
							{
								buttonMannschaftenVerwalten = new JButton("Mannschaften verwalten");
								buttonMannschaftenVerwalten.setToolTipText("Hier k\u00F6nnen Sie Mannschaften anzeigen lassen, hinzuf\u00FCgen, \u00E4ndern und l\u00F6schen.");

								btnNewButtonZeitblockaendern = new JButton("Zeitbl\u00F6cke verwalten");
								btnNewButtonZeitblockaendern.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										EventQueue.invokeLater(new Runnable() {
											public void run() {
												try {
													ZeitBloecke frame = new ZeitBloecke();
													frame.setVisible(true);
												} catch (Exception e) {
													e.printStackTrace();
												}
											}
										});
									}
								});
								{
									buttonNewButton = new JButton("Sportart verwalten");
								}
								buttonMannschaftenVerwalten.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										try {
											buttonMannschaftenVerwaltenActionPerformed(e);
										} catch (ClassNotFoundException e1) {
											e1.printStackTrace();
										}
									}
								});
							}
							buttonSportartVerwalten.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									buttonSportartVerwaltenActionPerformed(e);
								}
							});
						}
					}
					buttonAktualisieren.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							table.updateUI();
						}
					});
				}
			}
		}
		{
			labelHerzlichWillkommen = new JLabel("Herzlich Willkommen!");
			labelHerzlichWillkommen.setHorizontalAlignment(SwingConstants.CENTER);
			labelHerzlichWillkommen.setToolTipText("Schoen, dass sie da sind!");
		}

		{
			new ImageIcon("Unbenannt.png");
		}
		{


			//			String[] columnName = {"Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"};
			//			String[][] data = new String[7][22];
			//			String test = null;
			//			ArrayList <Training> ArrayListTraining = new ArrayList<Training>();
			//			for (int i = 0; i < 7; i++) {
			//				for ( int j = 8; j <= 22; j++){
			//					ArrayListTraining = vereinDao.select(comboBox_Halle.getSelectedIndex(),columnName[i], j);
			//					for(Training t : ArrayListTraining) {
			//						test = t.getMannschaft().getName() + t.getMannschaft().getSportart().getName();
			//					}
			//					data[i][j] = test;
			//				}
			//			}

		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("Dies ist der Wochenplan, der oben ausgewaehlten Halle");
		table = new JTable(48,8);
		table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		table.setDefaultRenderer(String.class, new TestRenderer());  // TODO
		scrollPane.setViewportView(table);
		String[] columns = new String[] {
				"Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"
		};
 
		table.updateUI();
		repaint();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(109)
										.addComponent(labelHerzlichWillkommen, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE))
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(panel, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
										.addGap(0))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(labelHerzlichWillkommen, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGap(11)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
						.addGap(7))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
								.addContainerGap())
				);
		
		buttonTrainingVerwalten = new JButton("Training verwalten");
		buttonTrainingVerwalten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buttonTrainingVerwaltenActionPerformed(e);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		buttonNewMitgliederVerwalten = new JButton("Mitglieder verwalten");
		buttonNewMitgliederVerwalten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonNewMitgliederVerwaltenActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(3)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(labelBild, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 214, Short.MAX_VALUE)
						.addComponent(button_Abmelden, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
						.addComponent(buttonTrainingVerwalten, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
						.addComponent(buttonSportartVerwalten, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
						.addComponent(buttonNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
						.addComponent(buttonMannschaftenVerwalten, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
						.addComponent(btnNewButtonZeitblockaendern, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
						.addComponent(buttonAktualisieren, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
						.addComponent(buttonNewMitgliederVerwalten, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
					.addGap(3))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(buttonAktualisieren, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButtonZeitblockaendern, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonMannschaftenVerwalten, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonNewButton, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonSportartVerwalten)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonTrainingVerwalten)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonNewMitgliederVerwalten)
					.addGap(4)
					.addComponent(button_Abmelden, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelBild, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);


	}

	// Wenn Button anmelden gedr�ckt, dann rufe wieder JFrame HallenPlan auf
	protected void button_AbmeldenActionPerformed(ActionEvent e) { 
		HallenPlan frame1 = new HallenPlan();
		frame1.setVisible(true);
		this.dispose();
		frame1.setLocationRelativeTo(null);
	}

	// Wenn Button Sportart verwalten gedr�ckt, dann rufe JFrame Sportart auf
	protected void buttonSportartVerwaltenActionPerformed(ActionEvent e) {
		JFrameSportart jFrameSportart = new JFrameSportart();
		jFrameSportart.setVisible(true);
	}

	// Wenn Button Mannschaft gedr�ckt, dann rufe JFrame Mannschaft auf
	protected void buttonMannschaftenVerwaltenActionPerformed(ActionEvent e) throws ClassNotFoundException {
		JFrameMannschaft jFrameMannschaft = new JFrameMannschaft();
		jFrameMannschaft.setVisible(true);
	}

	public void tabellebilden() {
		String[][] tabellenanzeige = new String[48][8];
		for (int i = 0; i < tabellenanzeige.length; i++) {

		}
	}

	

//	public String[][] getTableContentArray(){
//		String[][] tableContentArray = new String[96][8];
//		
//		// Zeitbl�cke von DAO holen
//		for(Block zeitblock: zeitbl�cke){
//			int column;
//		}
//		int start = Block.getZeitbeginn();
//		// Start == 60
//		int row = (start)
//		
//		return tableContentArray;
	//}

	protected void buttonTrainingVerwaltenActionPerformed(ActionEvent e) throws ClassNotFoundException {
		JFrameTraining jFrameTraining = new JFrameTraining();
		jFrameTraining.setVisible(true);
	}
	protected void buttonNewMitgliederVerwaltenActionPerformed(ActionEvent e) {
		JFrameMitglied jFrameMitglied = new JFrameMitglied();
		jFrameMitglied.setVisible(true);
	}
}
