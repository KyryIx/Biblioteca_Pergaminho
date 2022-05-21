package BancoDados;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// https://refactoring.guru/pt-br/design-patterns/singleton/java/example
// https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
// https://www.w3schools.com/java/java_arraylist.asp
// https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
// https://docs.oracle.com/javase/7/docs/api/java/sql/Connection.html

public final class Database {
	private static Database instance = null;
	private boolean state = false;
	private String message = "";
	
	private String databaseServer   = "mysql";
	private String databaseHost     = "localhost";
	private int databasePort        = 3306;
	private String databaseUser     = "root";
	private String databasePassword = "";
	private String databaseName     = "biblioteca";
	
	private Connection connection;
    
    private Database(){
    	String DATABASE_URL = String.format("jdbc:%s://%s:%d/%s",
    										this.databaseServer,
    										this.databaseHost,
    										this.databasePort,
    										this.databaseName);
    	
    	try {
			this.connection = DriverManager.getConnection(
												DATABASE_URL,
												this.databaseUser,
												this.databasePassword);
			this.setState( true );
			this.setMessage( "Sucesso ao conectar" );
		}
    	catch (SQLException e) {
			e.printStackTrace();
			this.setState( false );
			this.setMessage( "Falha ao conectar" );
		}
    }
    
    public static Database getInstance(){
    	if( instance == null ){
    		instance = new Database();
        }
    	return instance;
    }
    
    public Connection getConnection() {
    	return this.connection;
    }
    
    private void setState( boolean state ) {
    	this.state = state;
    }
    
    public boolean getState() {
    	return this.state;
    }
    
    private void setMessage( String message ) {
    	this.message = message;
    }
    
    public String getMessage() {
    	return this.message;
    }
}
