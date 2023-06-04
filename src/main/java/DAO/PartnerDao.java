package DAO;

import DAO.myconnection.MyConnection;
import model.Partner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartnerDao {
    private final Connection connection = MyConnection.getConnection();

    private final String SELECT_ALL = "select * from partner;";
    private final String SELECT_BY_ID = "select * from partner where partner_id = ?;";
    private final String INSERT_INTO = "insert into partner(partner_name,partner_email,partner_gender,age,partner_status,partner_phone,partner_address) value (?,?,?,?,?,?,?);";
    private final String UPDATE_BY_ID = "update partner set partner_name = ?, partner_email = ?, partner_gender = ?, age = ?, partner_status = ?, partner_phone = ?, partner_address = ? where partner_id = ?;";
    private final String DELETE_BY_ID = "delete from partner where partner_id = ?";
    private final String SEARCH_BY_NAME = "select * from partner where partner_name like ?;";

    public List<Partner> findAll() {
        List<Partner> partnerList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int partner_id = resultSet.getInt("partner_id");
                String partner_name = resultSet.getString("partner_name");
                String partner_email = resultSet.getString("partner_email");
                String partner_gender = resultSet.getString("partner_gender");
                int age = resultSet.getInt("age");
                String partner_status = resultSet.getString("partner_status");
                String partner_phone = resultSet.getString("partner_phone");
                String partner_address = resultSet.getString("partner_address");
                Partner partner = new Partner(partner_id, partner_name,partner_email,partner_gender,age,partner_status,partner_phone,partner_address);
                partnerList.add(partner);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partnerList;
    }

    public Partner findById(int id) {
        Partner partner = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String partner_name = resultSet.getString("partner_name");
                partner = new Partner(id, partner_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partner;
    }
    public void addPartner(Partner partner) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setInt(1, partner.getPartner_id());
            preparedStatement.setString(2, partner.getPartner_name());
            preparedStatement.setString(3, partner.getPartner_email());
            preparedStatement.setString(4, partner.getPartner_gender());
            preparedStatement.setInt(5, partner.getAge());
            preparedStatement.setString(6, partner.getPartner_status());
            preparedStatement.setString(7, partner.getPartner_phone());
            preparedStatement.setString(8, partner.getPartner_address());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePartner(Partner partner) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID)) {
            preparedStatement.setString(1, partner.getPartner_name());
            preparedStatement.setString(2, partner.getPartner_email());
            preparedStatement.setString(3, partner.getPartner_gender());
            preparedStatement.setInt(4, partner.getAge());
            preparedStatement.setString(5, partner.getPartner_status());
            preparedStatement.setString(6, partner.getPartner_phone());
            preparedStatement.setString(7, partner.getPartner_address());
            preparedStatement.setInt(8, partner.getPartner_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteById(int id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Partner> searchByName(String name) {
        List<Partner> partnerList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME)) {
            preparedStatement.setString(1, "%" + name + "%");
            convertResultSetToList(partnerList, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return partnerList;
    }
    private void convertResultSetToList(List<Partner> partnerList, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int partner_id = resultSet.getInt("partner_id");
            String partner_name = resultSet.getString("partner_name");
            String partner_email = resultSet.getString("partner_email");
            String partner_gender = resultSet.getString("partner_gender");
            int age = resultSet.getInt("age");
            String partner_status = resultSet.getString("partner_status");
            String partner_phone = resultSet.getString("partner_phone");
            String partner_address = resultSet.getString("partner_address");
            Partner partner = new Partner(partner_id, partner_name, partner_email, partner_gender, age, partner_status,partner_phone,partner_address);
            partnerList.add(partner);
        }
    }

}

