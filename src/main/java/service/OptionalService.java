package service;

import DAO.OptionalDao;
import model.Optional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class OptionalService {
    private final OptionalDao optionalDao;
    private static OptionalService optionalService;

    private OptionalService() {
        optionalDao = new OptionalDao();
    }
    public static OptionalService getInstance() {
        if (optionalService == null) {
            optionalService = new OptionalService();
        }
        return optionalService;
    }
    public List<Optional> findAll() {
        return optionalDao.findAll();
    }
    public Optional getById(int id) {
        return optionalDao.findById(id);
    }
    public void save(HttpServletRequest request) {
        String optional_id = request.getParameter("optional_id");
        String optional_name = request.getParameter("optional_name");
        String description = request.getParameter("description");
        double optional_price = Double.parseDouble(request.getParameter("optional_price"));
        if (optional_id != null) {
            int idUpdate = Integer.parseInt(optional_id);
            optionalDao.updateOptional(new Optional(idUpdate, optional_name,description,optional_price));
        } else {
            optionalDao.addOptional(new Optional(optional_name,description,optional_price));
        }
    }
    public void deleteById(int id) {
        optionalDao.deleteById(id);
    }

    public boolean checkById(int id) {
        Optional optional = optionalDao.findById(id);
        return optional != null;
    }
}
