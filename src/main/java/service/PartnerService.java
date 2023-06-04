package service;

import DAO.PartnerDao;
import model.Partner;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PartnerService {
    private PartnerDao partnerDao;
    private static PartnerService partnerService;
    private PartnerService() {
        partnerDao= new PartnerDao();
    }

    public static PartnerService getInstance() {
        if (partnerService == null) {
            partnerService = new PartnerService();
        }
        return partnerService;
    }
    public List<Partner> findAll() {
        return partnerDao.findAll();
    }

    public Partner getById(int id) {
        return partnerDao.findById(id);
    }
    public void save(HttpServletRequest request) {
        String partner_id = request.getParameter("partner_id");
        String partner_name = request.getParameter("partner_name");
        String partner_email = request.getParameter("partner_email");
        String partner_gender = request.getParameter("partner_gender");
        int age = Integer.parseInt(request.getParameter("age"));
        String partner_status = request.getParameter("partner_status");
        String partner_phone = request.getParameter("partner_phone");
        String partner_address = request.getParameter("partner_address");
        if (partner_id != null) {
            int idUpdate = Integer.parseInt(partner_id);
            partnerDao.updatePartner(new Partner(idUpdate, partner_name, partner_email,partner_gender,age
                    ,partner_status,partner_phone,partner_address));
        } else {
            partnerDao.addPartner(new Partner(partner_name,partner_email,partner_gender
                    ,age,partner_status,partner_phone,partner_address));
        }
    }
    public void deleteById(int id) {
        partnerDao.deleteById(id);
    }
    public List<Partner> searchByName(HttpServletRequest request) {
        String search = request.getParameter("search");
        return partnerDao.searchByName(search);
    }

    public boolean checkById(int id) {
        Partner partner = partnerService.getById(id);
        return partner != null;
    }
}
