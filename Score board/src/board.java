import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class board {

	private static JFrame frmScoreBoard;
	private JTable table;
	private static JTextField txtPlayer;
	private static JTextField textField;
	About ab = new About();
	
public static void checkInt() {
	// Method to check if the "Score" is an Integer
	try {
	     Integer.parseInt(textField.getText());
		}
	catch (NumberFormatException e1) {
    	 JOptionPane.showMessageDialog(frmScoreBoard, "Score must be a number!");
		}
}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					board window = new board();
					window.frmScoreBoard.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public board() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmScoreBoard = new JFrame();
		frmScoreBoard.setTitle("Scoreboard");
		frmScoreBoard.setBounds(100, 100, 450, 300);
		frmScoreBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmScoreBoard.setJMenuBar(menuBar);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		//Creating menu bar and menu item "Developer"
		JMenuItem mntmDeveloper = new JMenuItem("Developer");
		mntmDeveloper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//onClick-action on "Developer"-menu item. Opens the "About" tab.
				ab.setVisible(true);
			}
		});
		mnAbout.add(mntmDeveloper);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		//Closes the menu
		mnAbout.add(mntmClose);
		frmScoreBoard.getContentPane().setLayout(null);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 178);
		frmScoreBoard.getContentPane().add(scrollPane);
		// Scrolling option in case the score list gets too big
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		@SuppressWarnings("serial")
		DefaultTableModel model = new DefaultTableModel(new String[]{"Player", "Score"}, 0) {
		@SuppressWarnings("rawtypes")
		Class[] types = {String.class, Integer.class };
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
         public Class getColumnClass(int columnIndex) {
             return this.types[columnIndex];
         }
		};
		
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		
		
		JButton btnNewButton = new JButton("Add new score");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {;
				// onclick action when clicking the button. It takes written info from the textfields and adds them to the table
			checkInt();
			
			String newPlayer = txtPlayer.getText();
			int newScore = Integer.parseInt(textField.getText());
			
			if (txtPlayer.getText().equals("") || textField.getText().equals("")) {
				// Making sure that textfields are not empty.
				System.out.println("Please fill both textfields.");
				JOptionPane.showMessageDialog(frmScoreBoard, "Please fill both textfields.");
			} else  {
				model.addRow(new Object[]{newPlayer, newScore});
				table.setModel(model);
				txtPlayer.setText("");
				textField.setText("");
			}
			}
		});
		btnNewButton.setBounds(162, 190, 131, 41);
		frmScoreBoard.getContentPane().add(btnNewButton);
		
		JLabel lblPlayer = new JLabel("Player:");
		lblPlayer.setBounds(10, 194, 46, 14);
		frmScoreBoard.getContentPane().add(lblPlayer);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setBounds(10, 214, 46, 14);
		frmScoreBoard.getContentPane().add(lblScore);
		
		txtPlayer = new JTextField();
		txtPlayer.setBounds(66, 191, 86, 20);
		frmScoreBoard.getContentPane().add(txtPlayer);
		txtPlayer.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(66, 211, 86, 20);
		frmScoreBoard.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnDeleteRow = new JButton("Delete selected");
		btnDeleteRow.setForeground(Color.RED);
		btnDeleteRow.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDeleteRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Checking which rows are selected from the table and then deleting them
				int[] selectedRows = table.getSelectedRows();
		        if (selectedRows.length > 0) {
		            for (int i = selectedRows.length - 1; i >= 0; i--) {
		                model.removeRow(selectedRows[i]);
		            }
		        }
		        table.addNotify();
			}
		});
		btnDeleteRow.setBounds(293, 190, 131, 41);
		frmScoreBoard.getContentPane().add(btnDeleteRow);
	}
}
