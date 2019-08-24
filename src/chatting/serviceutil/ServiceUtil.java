package chatting.serviceutil;

import java.sql.Connection;
import java.sql.DriverManager;

//Java와 DataBase를 연결해주는 서비스 연결 객체
public class ServiceUtil {

	private static Connection con;

	public static Connection getConnection() {

		try {

			// 오라클드라이버를 동적으로 할당!!!
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ORANGE", "1234");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Connection fail");
			e.printStackTrace();

		}

		return con;

	}

}
