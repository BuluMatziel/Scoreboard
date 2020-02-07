import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class About extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			About dialog = new About();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public About() {
		setTitle("Tietoja ohjelmasta");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblVersio = new JLabel("Simple scoreboard made with Eclipse IDE");
		lblVersio.setHorizontalAlignment(SwingConstants.CENTER);
		lblVersio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVersio.setBounds(10, 11, 414, 31);
		contentPanel.add(lblVersio);
		{
			JLabel lblKehittjMatiasKohanevic = new JLabel("Developer: Matias Kohanevic");
			lblKehittjMatiasKohanevic.setHorizontalAlignment(SwingConstants.CENTER);
			lblKehittjMatiasKohanevic.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblKehittjMatiasKohanevic.setBounds(10, 53, 414, 31);
			contentPanel.add(lblKehittjMatiasKohanevic);
		}
		{
			JLabel lblOpiskelijanumero = new JLabel("Github: https://github.com/BuluMatziel");
			lblOpiskelijanumero.setHorizontalAlignment(SwingConstants.CENTER);
			lblOpiskelijanumero.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblOpiskelijanumero.setBounds(10, 95, 414, 31);
			contentPanel.add(lblOpiskelijanumero);
		}
		{
			JLabel lblOtaYhteyttMatiaskohanevicgmailcom = new JLabel("Contact: matiaskohanevic@gmail.com");
			lblOtaYhteyttMatiaskohanevicgmailcom.setHorizontalAlignment(SwingConstants.CENTER);
			lblOtaYhteyttMatiaskohanevicgmailcom.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblOtaYhteyttMatiaskohanevicgmailcom.setBounds(10, 137, 414, 31);
			contentPanel.add(lblOtaYhteyttMatiaskohanevicgmailcom);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
