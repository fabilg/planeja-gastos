package br.com.planejagastos.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.planejagastos.config.DataSourceConfig;

public class SQLServerConnection implements DatabaseConnection {
   
    @Autowired
    private DataSourceConfig dataSourceConfig;

    @Override
    public Connection getConnection() {
    	
        try {
			return DriverManager.getConnection(dataSourceConfig.getUrl(), dataSourceConfig.getUsername(),
					dataSourceConfig.getPassword());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void closeConnection(Connection connection) {
    	
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }
}