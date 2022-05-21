import java.awt.EventQueue;

// https://www.iconfinder.com/icons/2388602/book_books_decoration_interior_icon
// https://www.iconfinder.com/icons/4243327/ux_book_app_basic_icon
// https://www.iconfinder.com/icons/4243329/ux_book_app_basic_icon
// https://www.iconfinder.com/icons/4243264/ux_app_paper_basic_icon
// https://www.iconfinder.com/icons/4243253/basic_phone_app_ux_icon
// https://docs.oracle.com/javase/tutorial/uiswing/components/icon.html
// https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html
// https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-connect-drivermanager.html
// https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-statements.html
// https://www.w3schools.com/sql/sql_primarykey.ASP
// https://www.devmedia.com.br/criando-uma-conexao-java-mysql-server/16753
// https://jar-download.com/artifacts/mysql/mysql-connector-java

// Java - Como Programar - 10ª Edição - Deitel
// Capitulo 27 - Acesso a bancos de dados com JDBC

// https://sabiofameblu.uniasselvi.com.br/sabio/

public class Main {
	public static final String serialVersionUID = "1.0.0";
	
	// Launch the application //
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
