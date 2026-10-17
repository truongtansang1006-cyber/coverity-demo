package demo;

import java.sql.*;

public class VehicleDao {

    // Code CÓ LỖI để Coverity phát hiện
    public String getName(Connection con, String id) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(
            "SELECT name FROM Vehicle WHERE id='" + id + "'");
        String name = null;
        if (rs.next()) {
            name = rs.getString(1);
        }
        return name.trim();
    }
}
