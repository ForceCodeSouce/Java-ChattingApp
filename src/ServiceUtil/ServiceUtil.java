package ServiceUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class ServiceUtil {

	// ���ᰴü �ʿ�
	private static Connection con;

	static {
		System.out.println("Connect...");

		try {

			//�̱������� �������� ��ü!!! (1)
			// ����̹��� �������� �������� �޼ҵ�
			// ����Ŭ����̹��� �������� �ε�
			// Ȯ���ڴ� �A�� -> oracle.jdbc.driver.OracleDriver.class -> .class ����
			// ��ΰ� �߸��Ǹ� ClassNotFoundException ���� �߻�
			//Class.forName("oracle.jdbc.OracleDriver");
			
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ORANGE", "1234");

//			System.out.println("ConnectSucess");
//			System.out.println(con);
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println("Connect Fail");
			//e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() {
		
		
		//�Ϲ������� �������� ��ü !!! (2)
		try {
			//����Ŭ����̹��� �������� �Ҵ�!!!
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
