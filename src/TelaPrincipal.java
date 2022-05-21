import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Ajuda.DialogoSobreAjuda;
import Livro.*;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// Create the frame //
	public TelaPrincipal() throws Exception {
		setResizable(false);
		
		String title = "Biblioteca Pergaminho v" + Main.serialVersionUID;  
		setTitle( title );
		setIconImage( Toolkit.getDefaultToolkit().getImage( getClass().getResource("resources/book.png") ) );
		
		//setIconImage( Toolkit.getDefaultToolkit().getImage( -- ) );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 218);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(NORMAL);
			}
		});
		mnArquivo.add(mntmSair);
		
		JMenu mnEmprstimo = new JMenu("Empr\u00E9stimo");
		menuBar.add(mnEmprstimo);
		
		JMenuItem mntmEmprestar = new JMenuItem("Emprestar");
		mnEmprstimo.add(mntmEmprestar);
		
		JMenuItem mntmReservar = new JMenuItem("Reservar");
		mnEmprstimo.add(mntmReservar);
		
		JMenuItem mntmConsultar_2 = new JMenuItem("Consultar");
		mnEmprstimo.add(mntmConsultar_2);
		
		JMenu mnPesquisa = new JMenu("Pesquisa");
		menuBar.add(mnPesquisa);
		
		JMenuItem mntmPesquisaSimples = new JMenuItem("Pesquisa Simples");
		mnPesquisa.add(mntmPesquisaSimples);
		
		JMenuItem mntmPesquisaAvanada = new JMenuItem("Pesquisa Avan\u00E7ada");
		mnPesquisa.add(mntmPesquisaAvanada);
		
		JMenu mnUsurio = new JMenu("Usu\u00E1rio");
		menuBar.add(mnUsurio);
		
		JMenuItem mntmConsultar_1 = new JMenuItem("Consultar");
		mnUsurio.add(mntmConsultar_1);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mnUsurio.add(mntmCadastrar);
		
		JMenu mnLivros = new JMenu("Livro");
		menuBar.add(mnLivros);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DialogoConsultarLivro dialog = new DialogoConsultarLivro();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		mnLivros.add(mntmConsultar);
		
		JMenuItem mntmInserir = new JMenuItem("Inserir");
		mntmInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DialogoInserirLivro dialog = new DialogoInserirLivro();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		mnLivros.add(mntmInserir);
		
		JMenuItem mntmAtualizar = new JMenuItem("Atualizar");
		mntmAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DialogoAtualizarLivro dialog = new DialogoAtualizarLivro();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		mnLivros.add(mntmAtualizar);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DialogoExcluirLivro dialog = new DialogoExcluirLivro();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		mnLivros.add(mntmExcluir);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);
		
		JMenuItem mntmManual = new JMenuItem("Manual");
		mnAjuda.add(mntmManual);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/resources/hand_help_rotate_16.png")));
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DialogoSobreAjuda dialog = new DialogoSobreAjuda();
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		mnAjuda.add(mntmSobre);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("");
		//label.setIcon(new ImageIcon("C:\\Users\\OdyCruz\\Desktop\\UNIASSELVI 2022-1\\[5] PROJETO ORIENTADO A OBJETOS\\AULA 10\\Biblioteca\\book.png"));
		label.setIcon( new ImageIcon( Toolkit.getDefaultToolkit().getImage( getClass().getResource("resources/book.png") ) ) );
		contentPane.add(label);
	}

}
