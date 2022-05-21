package Livro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

import BancoDados.Database;

public class DialogoConsultarLivro extends JDialog {
	private static final long serialVersionUID = 1L;
	private Database database;
	Statement statement;
	ResultSet resultSet; 
	private String sql_query;
	private int numberRegisters;
	private int registerCurrent;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCutter;
	private JTextField textFieldCcd;
	private JTextField textFieldIsbn;
	private JTextField textFieldId;
	private JTextField textFieldColecao;
	private JTextField textFieldAutorPrincipal;
	private JTextField textFieldTitulo;
	private JTextField textFieldEdicao;
	private JTextField textFieldCidade;
	private JTextField textFieldEditora;
	private JTextField textFieldAno;
	private JTextField textFieldPaginas;
	private JTextField textFieldAssunto;
	private JTextField textFieldAutoresSecundarios;
	private JTextField textFieldCampus;
	private JTextField textFieldNota;
	
	private JLabel labelTextoRegistros;
	
	/**
	 * Create the dialog.
	 */
	public DialogoConsultarLivro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoConsultarLivro.class.getResource("/resources/book_select.png")));
		setBounds(100, 100, 530, 525);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {97, 97, 97, 97, 0};
		gbl_contentPanel.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		
		JLabel labelId = new JLabel("ID:");
		GridBagConstraints gbc_labelId = new GridBagConstraints();
		gbc_labelId.anchor = GridBagConstraints.EAST;
		gbc_labelId.fill = GridBagConstraints.VERTICAL;
		gbc_labelId.insets = new Insets(0, 5, 5, 5);
		gbc_labelId.gridx = 0;
		gbc_labelId.gridy = 0;
		contentPanel.add(labelId, gbc_labelId);
		
		textFieldId = new JTextField();
		GridBagConstraints gbc_textFieldId = new GridBagConstraints();
		gbc_textFieldId.gridwidth = 2;
		gbc_textFieldId.fill = GridBagConstraints.BOTH;
		gbc_textFieldId.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldId.gridx = 1;
		gbc_textFieldId.gridy = 0;
		contentPanel.add(textFieldId, gbc_textFieldId);
		textFieldId.setColumns(4);
		
		JLabel labelFoto = new JLabel("Imagem\r\n");
		labelFoto.setBackground(Color.ORANGE);
		GridBagConstraints gbc_labelFoto = new GridBagConstraints();
		gbc_labelFoto.gridheight = 5;
		gbc_labelFoto.gridwidth = 2;
		gbc_labelFoto.insets = new Insets(0, 0, 5, 5);
		gbc_labelFoto.gridx = 3;
		gbc_labelFoto.gridy = 0;
		contentPanel.add(labelFoto, gbc_labelFoto);
		
		JLabel labelIsbn = new JLabel("ISBN:");
		GridBagConstraints gbc_labelIsbn = new GridBagConstraints();
		gbc_labelIsbn.anchor = GridBagConstraints.EAST;
		gbc_labelIsbn.fill = GridBagConstraints.VERTICAL;
		gbc_labelIsbn.insets = new Insets(0, 5, 5, 5);
		gbc_labelIsbn.gridx = 0;
		gbc_labelIsbn.gridy = 1;
		contentPanel.add(labelIsbn, gbc_labelIsbn);
		
		textFieldIsbn = new JTextField();
		GridBagConstraints gbc_textFieldIsbn = new GridBagConstraints();
		gbc_textFieldIsbn.gridwidth = 2;
		gbc_textFieldIsbn.fill = GridBagConstraints.BOTH;
		gbc_textFieldIsbn.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldIsbn.gridx = 1;
		gbc_textFieldIsbn.gridy = 1;
		contentPanel.add(textFieldIsbn, gbc_textFieldIsbn);
		textFieldIsbn.setColumns(4);
		
		JLabel labelCcd = new JLabel("CCD:");
		GridBagConstraints gbc_labelCcd = new GridBagConstraints();
		gbc_labelCcd.anchor = GridBagConstraints.EAST;
		gbc_labelCcd.fill = GridBagConstraints.VERTICAL;
		gbc_labelCcd.insets = new Insets(0, 5, 5, 5);
		gbc_labelCcd.gridx = 0;
		gbc_labelCcd.gridy = 2;
		contentPanel.add(labelCcd, gbc_labelCcd);
		
		textFieldCcd = new JTextField();
		GridBagConstraints gbc_textFieldCcd = new GridBagConstraints();
		gbc_textFieldCcd.gridwidth = 2;
		gbc_textFieldCcd.fill = GridBagConstraints.BOTH;
		gbc_textFieldCcd.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCcd.gridx = 1;
		gbc_textFieldCcd.gridy = 2;
		contentPanel.add(textFieldCcd, gbc_textFieldCcd);
		textFieldCcd.setColumns(8);
		
		JLabel labelCutter = new JLabel("Cutter:");
		GridBagConstraints gbc_labelCutter = new GridBagConstraints();
		gbc_labelCutter.anchor = GridBagConstraints.EAST;
		gbc_labelCutter.fill = GridBagConstraints.VERTICAL;
		gbc_labelCutter.insets = new Insets(0, 5, 5, 5);
		gbc_labelCutter.gridx = 0;
		gbc_labelCutter.gridy = 3;
		contentPanel.add(labelCutter, gbc_labelCutter);
		
		textFieldCutter = new JTextField();
		GridBagConstraints gbc_textFieldCutter = new GridBagConstraints();
		gbc_textFieldCutter.gridwidth = 2;
		gbc_textFieldCutter.fill = GridBagConstraints.BOTH;
		gbc_textFieldCutter.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCutter.gridx = 1;
		gbc_textFieldCutter.gridy = 3;
		contentPanel.add(textFieldCutter, gbc_textFieldCutter);
		textFieldCutter.setColumns(1);
		
		JLabel labelColecao = new JLabel("Cole\u00E7\u00E3o:");
		GridBagConstraints gbc_labelColecao = new GridBagConstraints();
		gbc_labelColecao.anchor = GridBagConstraints.EAST;
		gbc_labelColecao.fill = GridBagConstraints.VERTICAL;
		gbc_labelColecao.insets = new Insets(0, 5, 5, 5);
		gbc_labelColecao.gridx = 0;
		gbc_labelColecao.gridy = 4;
		contentPanel.add(labelColecao, gbc_labelColecao);
		
		textFieldColecao = new JTextField();
		GridBagConstraints gbc_textFieldColecao = new GridBagConstraints();
		gbc_textFieldColecao.gridwidth = 2;
		gbc_textFieldColecao.fill = GridBagConstraints.BOTH;
		gbc_textFieldColecao.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldColecao.gridx = 1;
		gbc_textFieldColecao.gridy = 4;
		contentPanel.add(textFieldColecao, gbc_textFieldColecao);
		textFieldColecao.setColumns(10);
		
		JLabel labelAutorPrincipal = new JLabel("Autor principal:");
		GridBagConstraints gbc_labelAutorPrincipal = new GridBagConstraints();
		gbc_labelAutorPrincipal.anchor = GridBagConstraints.EAST;
		gbc_labelAutorPrincipal.fill = GridBagConstraints.VERTICAL;
		gbc_labelAutorPrincipal.insets = new Insets(0, 5, 5, 5);
		gbc_labelAutorPrincipal.gridx = 0;
		gbc_labelAutorPrincipal.gridy = 5;
		contentPanel.add(labelAutorPrincipal, gbc_labelAutorPrincipal);
		
		textFieldAutorPrincipal = new JTextField();
		GridBagConstraints gbc_textFieldAutorPrincipal = new GridBagConstraints();
		gbc_textFieldAutorPrincipal.gridwidth = 4;
		gbc_textFieldAutorPrincipal.fill = GridBagConstraints.BOTH;
		gbc_textFieldAutorPrincipal.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAutorPrincipal.gridx = 1;
		gbc_textFieldAutorPrincipal.gridy = 5;
		contentPanel.add(textFieldAutorPrincipal, gbc_textFieldAutorPrincipal);
		textFieldAutorPrincipal.setColumns(10);
		
		JLabel labelTitulo = new JLabel("T\u00EDtulo:");
		GridBagConstraints gbc_labelTitulo = new GridBagConstraints();
		gbc_labelTitulo.anchor = GridBagConstraints.EAST;
		gbc_labelTitulo.fill = GridBagConstraints.VERTICAL;
		gbc_labelTitulo.insets = new Insets(0, 5, 5, 5);
		gbc_labelTitulo.gridx = 0;
		gbc_labelTitulo.gridy = 6;
		contentPanel.add(labelTitulo, gbc_labelTitulo);
		
		textFieldTitulo = new JTextField();
		GridBagConstraints gbc_textFieldTitulo = new GridBagConstraints();
		gbc_textFieldTitulo.gridwidth = 4;
		gbc_textFieldTitulo.fill = GridBagConstraints.BOTH;
		gbc_textFieldTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTitulo.gridx = 1;
		gbc_textFieldTitulo.gridy = 6;
		contentPanel.add(textFieldTitulo, gbc_textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		JLabel labelEdicao = new JLabel("Edi\u00E7\u00E3o:");
		GridBagConstraints gbc_labelEdicao = new GridBagConstraints();
		gbc_labelEdicao.anchor = GridBagConstraints.EAST;
		gbc_labelEdicao.fill = GridBagConstraints.VERTICAL;
		gbc_labelEdicao.insets = new Insets(0, 5, 5, 5);
		gbc_labelEdicao.gridx = 0;
		gbc_labelEdicao.gridy = 7;
		contentPanel.add(labelEdicao, gbc_labelEdicao);
		
		textFieldEdicao = new JTextField();
		GridBagConstraints gbc_textFieldEdicao = new GridBagConstraints();
		gbc_textFieldEdicao.gridwidth = 4;
		gbc_textFieldEdicao.fill = GridBagConstraints.BOTH;
		gbc_textFieldEdicao.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldEdicao.gridx = 1;
		gbc_textFieldEdicao.gridy = 7;
		contentPanel.add(textFieldEdicao, gbc_textFieldEdicao);
		textFieldEdicao.setColumns(10);
		
		JLabel labelCidade = new JLabel("Cidade:");
		GridBagConstraints gbc_labelCidade = new GridBagConstraints();
		gbc_labelCidade.anchor = GridBagConstraints.EAST;
		gbc_labelCidade.fill = GridBagConstraints.VERTICAL;
		gbc_labelCidade.insets = new Insets(0, 5, 5, 5);
		gbc_labelCidade.gridx = 0;
		gbc_labelCidade.gridy = 8;
		contentPanel.add(labelCidade, gbc_labelCidade);
		
		textFieldCidade = new JTextField();
		GridBagConstraints gbc_textFieldCidade = new GridBagConstraints();
		gbc_textFieldCidade.gridwidth = 4;
		gbc_textFieldCidade.fill = GridBagConstraints.BOTH;
		gbc_textFieldCidade.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCidade.gridx = 1;
		gbc_textFieldCidade.gridy = 8;
		contentPanel.add(textFieldCidade, gbc_textFieldCidade);
		textFieldCidade.setColumns(10);
		
		JLabel labelEditora = new JLabel("Editora:");
		GridBagConstraints gbc_labelEditora = new GridBagConstraints();
		gbc_labelEditora.anchor = GridBagConstraints.EAST;
		gbc_labelEditora.fill = GridBagConstraints.VERTICAL;
		gbc_labelEditora.insets = new Insets(0, 5, 5, 5);
		gbc_labelEditora.gridx = 0;
		gbc_labelEditora.gridy = 9;
		contentPanel.add(labelEditora, gbc_labelEditora);
		
		textFieldEditora = new JTextField();
		GridBagConstraints gbc_textFieldEditora = new GridBagConstraints();
		gbc_textFieldEditora.gridwidth = 4;
		gbc_textFieldEditora.fill = GridBagConstraints.BOTH;
		gbc_textFieldEditora.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldEditora.gridx = 1;
		gbc_textFieldEditora.gridy = 9;
		contentPanel.add(textFieldEditora, gbc_textFieldEditora);
		textFieldEditora.setColumns(10);
		
		JLabel labelAno = new JLabel("Ano:");
		GridBagConstraints gbc_labelAno = new GridBagConstraints();
		gbc_labelAno.anchor = GridBagConstraints.EAST;
		gbc_labelAno.fill = GridBagConstraints.VERTICAL;
		gbc_labelAno.insets = new Insets(0, 5, 5, 5);
		gbc_labelAno.gridx = 0;
		gbc_labelAno.gridy = 10;
		contentPanel.add(labelAno, gbc_labelAno);
		
		textFieldAno = new JTextField();
		GridBagConstraints gbc_textFieldAno = new GridBagConstraints();
		gbc_textFieldAno.gridwidth = 4;
		gbc_textFieldAno.fill = GridBagConstraints.BOTH;
		gbc_textFieldAno.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAno.gridx = 1;
		gbc_textFieldAno.gridy = 10;
		contentPanel.add(textFieldAno, gbc_textFieldAno);
		textFieldAno.setColumns(10);
		
		JLabel labelPaginas = new JLabel("P\u00E1ginas:");
		GridBagConstraints gbc_labelPaginas = new GridBagConstraints();
		gbc_labelPaginas.anchor = GridBagConstraints.EAST;
		gbc_labelPaginas.fill = GridBagConstraints.VERTICAL;
		gbc_labelPaginas.insets = new Insets(0, 5, 5, 5);
		gbc_labelPaginas.gridx = 0;
		gbc_labelPaginas.gridy = 11;
		contentPanel.add(labelPaginas, gbc_labelPaginas);
		
		textFieldPaginas = new JTextField();
		GridBagConstraints gbc_textFieldPaginas = new GridBagConstraints();
		gbc_textFieldPaginas.gridwidth = 4;
		gbc_textFieldPaginas.fill = GridBagConstraints.BOTH;
		gbc_textFieldPaginas.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPaginas.gridx = 1;
		gbc_textFieldPaginas.gridy = 11;
		contentPanel.add(textFieldPaginas, gbc_textFieldPaginas);
		textFieldPaginas.setColumns(10);
		
		JLabel labelAssunto = new JLabel("Assunto:");
		GridBagConstraints gbc_labelAssunto = new GridBagConstraints();
		gbc_labelAssunto.anchor = GridBagConstraints.EAST;
		gbc_labelAssunto.fill = GridBagConstraints.VERTICAL;
		gbc_labelAssunto.insets = new Insets(0, 5, 5, 5);
		gbc_labelAssunto.gridx = 0;
		gbc_labelAssunto.gridy = 12;
		contentPanel.add(labelAssunto, gbc_labelAssunto);
		
		textFieldAssunto = new JTextField();
		GridBagConstraints gbc_textFieldAssunto = new GridBagConstraints();
		gbc_textFieldAssunto.gridwidth = 4;
		gbc_textFieldAssunto.fill = GridBagConstraints.BOTH;
		gbc_textFieldAssunto.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAssunto.gridx = 1;
		gbc_textFieldAssunto.gridy = 12;
		contentPanel.add(textFieldAssunto, gbc_textFieldAssunto);
		textFieldAssunto.setColumns(10);
		
		JLabel labelAutoresSecundarios = new JLabel("Autores secund\u00E1rios:");
		GridBagConstraints gbc_labelAutoresSecundarios = new GridBagConstraints();
		gbc_labelAutoresSecundarios.anchor = GridBagConstraints.EAST;
		gbc_labelAutoresSecundarios.fill = GridBagConstraints.VERTICAL;
		gbc_labelAutoresSecundarios.insets = new Insets(0, 5, 5, 5);
		gbc_labelAutoresSecundarios.gridx = 0;
		gbc_labelAutoresSecundarios.gridy = 13;
		contentPanel.add(labelAutoresSecundarios, gbc_labelAutoresSecundarios);
		
		textFieldAutoresSecundarios = new JTextField();
		GridBagConstraints gbc_textFieldAutoresSecundarios = new GridBagConstraints();
		gbc_textFieldAutoresSecundarios.gridwidth = 4;
		gbc_textFieldAutoresSecundarios.fill = GridBagConstraints.BOTH;
		gbc_textFieldAutoresSecundarios.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAutoresSecundarios.gridx = 1;
		gbc_textFieldAutoresSecundarios.gridy = 13;
		contentPanel.add(textFieldAutoresSecundarios, gbc_textFieldAutoresSecundarios);
		textFieldAutoresSecundarios.setColumns(10);
		
		JLabel labelCampus = new JLabel("Campus:");
		GridBagConstraints gbc_labelCampus = new GridBagConstraints();
		gbc_labelCampus.anchor = GridBagConstraints.EAST;
		gbc_labelCampus.fill = GridBagConstraints.VERTICAL;
		gbc_labelCampus.insets = new Insets(0, 5, 5, 5);
		gbc_labelCampus.gridx = 0;
		gbc_labelCampus.gridy = 14;
		contentPanel.add(labelCampus, gbc_labelCampus);
		
		textFieldCampus = new JTextField();
		GridBagConstraints gbc_textFieldCampus = new GridBagConstraints();
		gbc_textFieldCampus.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCampus.gridwidth = 4;
		gbc_textFieldCampus.fill = GridBagConstraints.BOTH;
		gbc_textFieldCampus.gridx = 1;
		gbc_textFieldCampus.gridy = 14;
		contentPanel.add(textFieldCampus, gbc_textFieldCampus);
		textFieldCampus.setColumns(10);
		
		JLabel labelNota = new JLabel("Nota:");
		GridBagConstraints gbc_labelNota = new GridBagConstraints();
		gbc_labelNota.anchor = GridBagConstraints.EAST;
		gbc_labelNota.fill = GridBagConstraints.VERTICAL;
		gbc_labelNota.insets = new Insets(0, 5, 0, 5);
		gbc_labelNota.gridx = 0;
		gbc_labelNota.gridy = 15;
		contentPanel.add(labelNota, gbc_labelNota);
		
		textFieldNota = new JTextField();
		GridBagConstraints gbc_textFieldNotas = new GridBagConstraints();
		gbc_textFieldNotas.gridwidth = 4;
		gbc_textFieldNotas.fill = GridBagConstraints.BOTH;
		gbc_textFieldNotas.gridx = 1;
		gbc_textFieldNotas.gridy = 15;
		contentPanel.add(textFieldNota, gbc_textFieldNotas);
		textFieldNota.setColumns(10);
		
		JPanel panelNavegacao = new JPanel();
		getContentPane().add(panelNavegacao, BorderLayout.CENTER);
		
		labelTextoRegistros = new JLabel("Registro 0 de 0 Registros");
		panelNavegacao.add(labelTextoRegistros);
		
		JButton buttonVoltar = new JButton("Voltar");
		buttonVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// evento voltar
				try{
					DialogoConsultarLivro dialog = DialogoConsultarLivro.this;
					
					// exibe os resultados da consulta
					if( (0 < (dialog.registerCurrent-1)) && (dialog.registerCurrent <= dialog.numberRegisters) ) {
						if( dialog.resultSet.previous() ){
							dialog.registerCurrent--;
							dialog.labelTextoRegistros.setText(
													String.format("Registro %d de %d Registros",
															dialog.registerCurrent, dialog.numberRegisters) );
							dialog.atualizarCampos();
						}
					}
				}
				catch( SQLException sqlException ){
					sqlException.printStackTrace();
				}
			}
		});
		
		JButton buttonAvancar = new JButton("Avan\u00E7ar");
		buttonAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// evento avancar
				try{
					DialogoConsultarLivro dialog = DialogoConsultarLivro.this;
					
					// exibe os resultados da consulta
					if( (1 <= dialog.registerCurrent) && ((dialog.registerCurrent+1) <= dialog.numberRegisters) ) {
						if( dialog.resultSet.next() ){
							dialog.registerCurrent++;
							dialog.labelTextoRegistros.setText(
													String.format("Registro %d de %d Registros",
															dialog.registerCurrent, dialog.numberRegisters) );
							dialog.atualizarCampos();
						}
					}
				}
				catch( SQLException sqlException ){
					sqlException.printStackTrace();
				}
			}
		});
		panelNavegacao.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelNavegacao.add(buttonVoltar);
		panelNavegacao.add(buttonAvancar);
		
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		JButton okButton = new JButton("Sair");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				JOptionPane.showMessageDialog(	null,
												"Salvo com sucesso.",
												"Aviso",
												JOptionPane.INFORMATION_MESSAGE );
				*/
				dispose();
			}
		});
		okButton.setActionCommand("Sair");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		/*
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		*/
		
		try{
			this.database = Database.getInstance();
			this.statement = database.getConnection().createStatement(
														ResultSet.TYPE_SCROLL_INSENSITIVE,
														ResultSet.CONCUR_UPDATABLE );
			//this.sql_query = "SELECT id, titulo, editora, ano FROM livros";
			this.sql_query = "SELECT * FROM livros";
			this.resultSet = statement.executeQuery( this.sql_query );
			
			this.numberRegisters = 0;
			this.registerCurrent = 0;
			
			this.resultSet.last();
			this.numberRegisters = this.resultSet.getRow();
			this.resultSet.beforeFirst();
			
			this.labelTextoRegistros.setText( String.format("Registro %d de %d Registros", this.registerCurrent, this.numberRegisters) );
	
			if( this.numberRegisters > 0 ) {
				// exibe os resultados da consulta
				if( this.resultSet.next() ){
					this.registerCurrent++;
					this.labelTextoRegistros.setText( String.format("Registro %d de %d Registros", this.registerCurrent, this.numberRegisters) );
					this.atualizarCampos();
				}
			}
		}
		catch( SQLException sqlException ){
			sqlException.printStackTrace();
		}
	}
	
	private boolean atualizarCampos() {
		try{			
			this.textFieldId.setText( this.resultSet.getObject("id").toString() );
			this.textFieldIsbn.setText( this.resultSet.getObject("isbn").toString() );
			this.textFieldCcd.setText( this.resultSet.getObject("ccd").toString() );
			this.textFieldCutter.setText( this.resultSet.getObject("cutter").toString() );
			this.textFieldColecao.setText( this.resultSet.getObject("colecao").toString() );
			this.textFieldAutorPrincipal.setText( this.resultSet.getObject("autor_principal").toString() );
			this.textFieldTitulo.setText( this.resultSet.getObject("titulo").toString() );
			this.textFieldEdicao.setText( this.resultSet.getObject("edicao").toString() );
			this.textFieldCidade.setText( this.resultSet.getObject("cidade").toString() );
			this.textFieldEditora.setText( this.resultSet.getObject("editora").toString() );
			this.textFieldAno.setText( this.resultSet.getObject("ano").toString() );
			this.textFieldPaginas.setText( this.resultSet.getObject("paginas").toString() );
			this.textFieldNota.setText( this.resultSet.getObject("nota").toString() );
			this.textFieldAssunto.setText( this.resultSet.getObject("assunto").toString() );
			this.textFieldAutoresSecundarios.setText( this.resultSet.getObject("autores_secundarios").toString() );
			this.textFieldCampus.setText( this.resultSet.getObject("campus").toString() );
			
			return true;
		}
		catch( SQLException sqlException ){
			sqlException.printStackTrace();
			return false;
		}
	}
}
