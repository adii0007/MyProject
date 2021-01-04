package in.co.sunrays.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

import in.co.sunrays.bean.CourseBean1;
import in.co.sunrays.bean.SubjectBean1;
import in.co.sunrays.exception.ApplicationException;
import in.co.sunrays.exception.DatabaseException;
import in.co.sunrays.exception.DuplicateRecordException;
import in.co.sunrays.proj4.util.JDBCDataSource;

public class SubjectModel1 {

public Integer nextPK() throws DatabaseException { 	
	
	Connection conn = null;
	int pk = 0;
	try {
		conn = JDBCDataSource.getconnection();
	    PreparedStatement pstmt = conn.prepareStatement("select MAX(ID) FROM ST_SUBJECT"); 
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
		 pk = rs.getInt(1);
		}
		rs.close();
			} catch (Exception e) {
		throw new DatabaseException("Exception : Exception in getting PK");
	} finally {
		JDBCDataSource.closeConnection(conn);
	}
	return pk + 1;
}	



public long Add(SubjectBean1 bean) throws ApplicationException,DuplicateRecordException {

	Connection conn = null;
	
	CourseModel1 cmodel = new CourseModel1();
    CourseBean1 courseBean1 = cmodel.findByPK(bean.getCourseid());
	bean.setCourseName(courseBean1.getName());
	
	SubjectBean1 duplicateName = findbyName(bean.getName());

	int pk = 0 ;
	
	if (duplicateName != null){
		throw new DuplicateRecordException("Subject alredy exist");
	}
	
	try { 
		conn = JDBCDataSource.getconnection();
		pk = nextPK();
		conn.setAutoCommit(false);
		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ST_SUBJECT VALUES(?,?,?,?,?,?,?,?,?)");
		pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getName());
		pstmt.setString(2, bean.getDescription());
		pstmt.setLong(3, bean.getCourseid());
		pstmt.setString(4, bean.getCourseName());
		pstmt.setString(6, bean.getcretedby());
        pstmt.setString(7, bean.getModifiedby());
        pstmt.setTimestamp(8, bean.getCreatedDatetime());
        pstmt.setTimestamp(9, bean.getModifiedDatetime());
        pstmt.executeUpdate();
        conn.commit();
        conn.close();
	} catch (Exception e) {
       
        try {
            conn.rollback();
        } catch (Exception ex) {
            throw new ApplicationException(
                    "Exception : add rollback exception " + ex.getMessage());
        }
        throw new ApplicationException(
                "Exception : Exception in add Subject");
    } finally {
        JDBCDataSource.closeConnection(conn);
    }
    
    return pk;
    
}
}













