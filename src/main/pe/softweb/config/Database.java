package pe.softweb.config;
import java.sql.SQLException;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

public class Database {
	private ConnectionSource connectionSource;
	public Database() throws SQLException{
		String databaseUrl = "jdbc:sqlite:db/db_accesos.db";
		connectionSource = new JdbcConnectionSource(databaseUrl);
	}
	public ConnectionSource getConnectionSource() {
		return connectionSource;
	}
}
