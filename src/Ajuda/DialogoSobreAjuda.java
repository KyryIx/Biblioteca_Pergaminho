package Ajuda;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.SystemColor;

public class DialogoSobreAjuda extends JDialog {
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public DialogoSobreAjuda() {
		// https://www.iconfinder.com/icons/2730360/hand_help_inkcontober_united_icon
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoSobreAjuda.class.getResource("/resources/hand_help_rotate.png")));
		setBounds(100, 100, 318, 195);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 0};
		gridBagLayout.rowHeights = new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DialogoSobreAjuda.class.getResource("/resources/eu.png")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JTextPane txtpnDesenvolvidoPorEverton = new JTextPane();
		txtpnDesenvolvidoPorEverton.setBackground(SystemColor.menu);
		txtpnDesenvolvidoPorEverton.setEditable(false);
		txtpnDesenvolvidoPorEverton.setText("Desenvolvido por Everton P. Cruz\r\nwww.everton.dev.br\r\n\r\nSoftware sobre a licen\u00E7a GPL 3.0.\r\n\r\nPara saber mais acesse o reposit\u00F3rio em github.com/KyryIx");
		GridBagConstraints gbc_txtpnDesenvolvidoPorEverton = new GridBagConstraints();
		gbc_txtpnDesenvolvidoPorEverton.gridheight = 7;
		gbc_txtpnDesenvolvidoPorEverton.anchor = GridBagConstraints.NORTH;
		gbc_txtpnDesenvolvidoPorEverton.gridwidth = 7;
		gbc_txtpnDesenvolvidoPorEverton.fill = GridBagConstraints.BOTH;
		gbc_txtpnDesenvolvidoPorEverton.gridx = 2;
		gbc_txtpnDesenvolvidoPorEverton.gridy = 1;
		getContentPane().add(txtpnDesenvolvidoPorEverton, gbc_txtpnDesenvolvidoPorEverton);

	}
}
