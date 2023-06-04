package DAO;

import DAO.myconnection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalPartnerDao {
    private final Connection connection = MyConnection.getConnection();
    private final String SELECT_OPTIONS_BY_PARTNER_ID = "SELECT optional.* FROM optional o " +
            "JOIN optional_partner op ON o.optional_id = op.optional_id " +
            "WHERE op.partner_id = ?;";
    private final String SELECT_PARTNERS_BY_OPTIONAL_ID = "SELECT p.* FROM partner p " +
            "JOIN optional_partner op ON p.partner_id = op.partner_id " +
            "WHERE op.optional_id = ?;";

}
