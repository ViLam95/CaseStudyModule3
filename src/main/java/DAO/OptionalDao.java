package DAO;

import DAO.myconnection.MyConnection;
import model.Optional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OptionalDao {
    private final Connection connection = MyConnection.getConnection();
    private final String SELECT_ALL = "select * from optional;";
    private final String SELECT_BY_ID = "select * from optional where optional_id = ?;";
    private final String INSERT_INTO = "insert into optional(optional_name,description,optional_price) value (?,?,?);";
    private final String UPDATE_BY_ID = "update optional set optional_name = ?, description = ?, optional_price = ? where optional_id = ?;";
    private final String DELETE_BY_ID = "delete from optional where optional_id = ?";
    private final String SEARCH_BY_NAME = "select * from optional where optional_name like ?;";

    public List<Optional> findAll() {
        List<Optional> optionalList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int optional_id = resultSet.getInt("optional_id");
                String optional_name = resultSet.getString("optional_name");
                Optional optional = new Optional(optional_id, optional_name);
                optionalList.add(optional);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return optionalList;
    }

    public Optional findById(int id) {
        Optional optional = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String option_name = resultSet.getString("option_name");
                String description = resultSet.getString("description");
                double option_price = resultSet.getDouble("option_price");
                optional = new Optional(id, option_name,description,option_price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return optional;
    }
    public void addOptional(Optional optional) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO)) {
            preparedStatement.setInt(1, optional.getOptional_id());
            preparedStatement.setString(2, optional.getOptional_name());
            preparedStatement.setString(3, optional.getDescription());
            preparedStatement.setDouble(4, optional.getOptional_price());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOptional(Optional optional) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID)) {
            preparedStatement.setInt(1, optional.getOptional_id());
            preparedStatement.setString(2, optional.getOptional_name());
            preparedStatement.setString(3, optional.getDescription());
            preparedStatement.setDouble(4, optional.getOptional_price());
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

    public List<Optional> searchByName(String name) {
        List<Optional> optionalList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME)) {
            preparedStatement.setString(1, "%" + name + "%");
            convertResultSetToList(optionalList, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return optionalList;
    }

    private void convertResultSetToList(List<Optional> optionalList, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int optional_id = resultSet.getInt("optional_id");
            String optional_name = resultSet.getString("optional_name");
            String description = resultSet.getString("description");
            double optional_price = resultSet.getDouble("optional_price");
            Optional optional = new Optional(optional_id, optional_name, description, optional_price);
            optionalList.add(optional);
        }
    }
}
