package demo;

import java.sql.*;

public class VehicleDao {

    public String getName(Connection con, String id) throws SQLException {
        String sql = "SELECT name FROM Vehicle WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString(1);
                    return name != null ? name.trim() : null;
                }
            }
        }
        return null;
    }
}
