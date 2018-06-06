package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Order;
import util.DbUtil;

/**    
 * @author zy
 * @date 2018Äê5ÔÂ28ÈÕ
 * @version 1.0
 */
public class OrderDaoImpl {

	public void save(Order o) {
		Connection conn = DbUtil.getConnection();
		String sql = "insert into tb_orders(state) values(?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,o.getState());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.release(null, pstmt, conn);
		}
	}
	
	public void update(Order o) {
		Connection conn = DbUtil.getConnection();
		String sql = "update tb_orders set state = ?";
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, o.getState());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.release(null, pstmt, conn);
		}
	}
	
	public Order findById(Integer id) {
		Order o = new Order();
		Connection conn = DbUtil.getConnection();
		String sql = "select * from tb_orders where id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				o.setId(rs.getInt("id"));
				o.setState(rs.getInt("state"));
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.release(rs, pstmt, conn);
		}
		return o;
	}
	
	public List<Order> findAll() {
		Connection conn = DbUtil.getConnection();
		String sql = "select * from tb_orders";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<Order> OrderList = new ArrayList<>();
			Order o = null;
			while(rs.next()) {
				o=new Order();
				o.setId(rs.getInt("id"));
				o.setState(rs.getInt("state"));
				OrderList.add(o);
			}
			return OrderList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.release(rs, pstmt, conn);
		}
		return null;
	}
	
}
