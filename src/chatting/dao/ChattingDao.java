package chatting.dao;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import chatting.model.ChattingMember;
import chatting.serviceutil.ServiceUtil;

/* DataBase Entitiy
 *  joinmember id name password nickname */

public class ChattingDao {

	//ChattingMember member - 객체로 받는 방법을 고민해보자!!!
	//객체로 받을수도 있을꺼 같다. - JPasswordField를 GetText로 받으면 될듯하다
	//그런데 이제 더 이상 권장하는 방법은 아니다.
	//이와 관련된 : 설명 : https://codeday.me/ko/qa/20190324/142409.html
	//해결했다. 그런데 JPasswordField로 받은건 DB에 암호화 되어서 저장된다. 쩐다!!!
	public static void InsertMember(String id, String name, char [] password, String ninkName) {
		
		// 연결객체
		Connection con = ServiceUtil.getConnection();
		// 운반객체
		PreparedStatement pstmt = null;
		
		try {
			System.out.println("Insert Event");
			String sql = "INSERT INTO joinmember VALUES (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			//pstmt.setCharacterStream(0, password);
			pstmt.setString(3, (String)password.toString());
			pstmt.setString(4, ninkName);
			
			pstmt.execute();
			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 메모리를 자유공간으로 돌려준다
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();

			} catch (Exception e) {
				// TODO: handle exception1
				e.printStackTrace();
			}
		}
	}

	

}
