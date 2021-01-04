package in.co.sunrays.proj4.util;

import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Connection;

import in.co.sunrays.exception.ApplicationException;

public final class JDBCDataSource {

	
	
	private static JDBCDataSource datasource;
	
	private JDBCDataSource() {
	}
	
	private ComboPooledDataSource cpds = null;
	
	
	public static JDBCDataSource getInstance(){
		if(datasource == null){
			
			
			ResourceBundle rb = ResourceBundle
                    .getBundle("in.co.sunrays.proj4.bundle.system");

			datasource = new JDBCDataSource();
			datasource.cpds= new ComboPooledDataSource();
			try{
				datasource.cpds.setDriverClass(rb.getString("driver"));
			}
			catch(Exception e){
				e.printStackTrace();
			}
			
			datasource.cpds.setJdbcUrl(rb.getString("url"));
			datasource.cpds.setUser(rb.getString("username"));
			datasource.cpds.setPassword(rb.getString("password"));
			datasource.cpds.setInitialPoolSize(new Integer((String) rb.getString("initialpoolsize")));
			datasource.cpds.setAcquireIncrement(new Integer((String)rb.getString("acquireIncrement")));
			datasource.cpds.setMaxPoolSize(new Integer((String) rb.getString("maxpoolsize")));
			datasource.cpds.setMaxIdleTime(new Integer((String)rb.getString("timeout")));
			datasource.cpds.setMinPoolSize(new Integer((String) rb.getString("minpoolsize")));
			
		}
		return datasource;
	}

	public static Connection getconnection() throws Exception {
		return (Connection) getInstance().cpds.getConnection();
		
	}
	
	
	public static void closeConnection(java.sql.Connection conn) {
		if(conn !=null){
			try{
				conn.close();
				
			} catch (Exception e) {
		}
	}
	}
	
	public static void trnRollback(Connection connection)
	throws ApplicationException {
		if (connection != null){
			try{
				connection.rollback();
			} catch(SQLException ex) {
				throw new ApplicationException(ex.toString());
				
			
			}
		}
	}
}