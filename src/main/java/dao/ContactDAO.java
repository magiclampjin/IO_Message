package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.ContactDTO;

public class ContactDAO {
	private static ContactDAO instance;
	   
	   private ContactDAO() {};
	   
	   
	   public static ContactDAO getInstance(){
	      if(instance == null) {
	         instance = new ContactDAO();
	      }
	      return instance;
	   }

	   private Connection getConnection() throws Exception{
	      // TODO Auto-generated method stub
	      Context ctx = new InitialContext();

	      DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysql");
	      return ds.getConnection();
	   }
	
	public List<ContactDTO> selectAll() throws Exception {
		List<ContactDTO> list = new ArrayList<>();
		String sql = "select * from contact";
		try(
				Connection con = this.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				){
			while(rs.next()){
				ContactDTO dto = new ContactDTO();
				int seq = rs.getInt("seq");
				String name = rs.getString("name");
				String contact = rs.getString("contact");
				dto.setSeq(seq);
				dto.setName(name);
				dto.setContact(contact);
				list.add(dto);
			}
			
		}
		return list;
	}
	
	public int insertContact(int seq, String name, String contact) throws Exception {
		String sql = "insert into contact values(?,?,?)";
		try(
				Connection con = this.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				){
			pst.setInt(1,seq);
			pst.setString(2,name);
			pst.setString(3,contact);
			return pst.executeUpdate();
		}
	}
	
}
