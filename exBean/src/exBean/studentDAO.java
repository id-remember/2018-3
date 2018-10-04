package exBean;
import java.sql.*;
import java.util.*;
public class studentDAO {
 public void insertStudent(studentVO item) throws Exception {
  String no = item.getNo();
  String name = item.getName();

  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","201800001","201800001");

  PreparedStatement pstmt = conn.prepareStatement("insert into student values(?,?)");
  pstmt.setString(1,no);
  pstmt.setString(2,name);
  pstmt.executeUpdate();

  pstmt.close();
  conn.close();
 }
 public List<studentVO> selectStudent() throws Exception {
	  List<studentVO> items = new ArrayList<studentVO>();
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","201800001","201800001");
	  PreparedStatement pstmt = conn.prepareStatement("select * from student");
	  ResultSet rs = pstmt.executeQuery();
	  while(rs.next()) {
	   studentVO item = new studentVO();
	   item.setNo(rs.getString("no"));
	   item.setName(rs.getString("name"));
	   items.add(item);
	   //System.out.print(items);
	  }

	  pstmt.close();
	  rs.close();
	  conn.close();
	  return items;
	 }
}
