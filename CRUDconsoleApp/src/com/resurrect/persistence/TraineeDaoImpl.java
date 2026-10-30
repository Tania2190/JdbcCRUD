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
		Trainee trainee = null;
		String selectQuery = "select tid, tname,temail,tcourse,tenrolldate from traineereg where tid=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			
			if (connection != null) {
				pstmt = connection.prepareStatement(selectQuery);
			}
			
			if (pstmt != null) {
				pstmt.setInt(1, tid);
				resultSet = pstmt.executeQuery();
			}
			
			if (resultSet != null) {
				if (resultSet.next()) {
					trainee = new Trainee();
					
					trainee.setTid(resultSet.getInt(1));
					trainee.setTname(resultSet.getString(2));
					trainee.setTemail(resultSet.getString(3));
					trainee.setTcourse(resultSet.getString(4));
					trainee.setEnrollmentDate(resultSet.getTimestamp(5).toLocalDateTime());
					
					return trainee;
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return trainee;
	}

	@Override
	public String updateTrainee(Trainee trainee) {
		String updateQuery = "update traineereg set tname=?,temail=?,tcourse=?,tenrolldate=? where tid=?";
		try {
			 connection = JdbcUtil.getJdbcConnection();
			 
			if (connection != null) {
				pstmt = connection.prepareStatement(updateQuery);
			}
			if (pstmt != null) {
				pstmt.setString(1, trainee.getTname());
				pstmt.setString(2, trainee.getTemail());
				pstmt.setString(3, trainee.getTcourse());
				pstmt.setTimestamp(4, Timestamp.valueOf(trainee.getEnrollmentDate()));
				pstmt.setInt(5, trainee.getTid());
				
				int update = pstmt.executeUpdate();
				if (update == 1) {
					return "success";
				}
			}
		} catch(SQLException | IOException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	public String deleteTrainee(Integer tid) {
		String deleteQuery = "delete from traineereg where tid=?";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(deleteQuery);
			}
			if (pstmt != null) {
				pstmt.setInt(1, tid);
				
				int update = pstmt.executeUpdate();
				if (update == 1) {
					return "success";
				} else {
					return "not found";
				}
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return "failure";
		}
		return "failure";
	}

}
