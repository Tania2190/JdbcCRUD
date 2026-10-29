package com.resurrect.persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.ressurect.util.JdbcUtil;
import com.resurrect.dto.Trainee;

public class TraineeDaoImpl implements ITraineeDao{
	
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;

	@Override
	public String addTrainee(String tname, String temail, String course, LocalDateTime enrollmentDate) {
		
		try {
			connection = JdbcUtil.getJdbcConnection();
			String sqlInsertQuery = "insert into traineereg(`tname`,`temail`,`tcourse`,`tenrolldate`)values(?,?,?,?)";
			
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlInsertQuery);
			}
			
			if (pstmt != null) {
				pstmt.setString(1, tname);
				pstmt.setString(2, temail);
				pstmt.setString(3, course);
				pstmt.setTimestamp(4, Timestamp.valueOf(enrollmentDate));
				
				int result = pstmt.executeUpdate();
				if(result == 1)
					return "success";
			}
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JdbcUtil.clearUpResources(connection, pstmt, resultSet);
			} catch (SQLException e) {
				System.out.println("Encountered a problem while closing the resources");
				e.printStackTrace();
			}
		}
		return "failure";
	}

	@Override
	public Trainee searchTrainee(Integer tid) {
		return null;
	}

	@Override
	public String updateTrainee(Trainee trainee) {
		return null;
	}

	@Override
	public String deleteTrainee(Integer tid) {
		return null;
	}

}
