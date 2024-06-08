/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oryzac18.controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oryzac16.model.Dosen;
import oryzac17.view.FormDosen;
import oryzac16.model.DosenDao;

/**
 *
 * @author ORYZA CONSEVA
 */
public class DosenController {
    FormDosen formDosen;
    Dosen dosen;
    DosenDao dosenDao;
    int index;
    
    public DosenController(FormDosen formDosen){
        this.formDosen = formDosen;
        dosenDao = new DosenDao();
    }
    
    public void cancel(){
        formDosen.getTxtNip().setText("");
        formDosen.getTxtNama().setText("");
        formDosen.getTxtAlamat().setText("");
        formDosen.getTxtTanggalLahir().setText("");
        isiJenisKelamin();
    }
    
    public void isiJenisKelamin(){
        formDosen.getCboJenisKelamin().removeAllItems();
        formDosen.getCboJenisKelamin().addItem("L");
        formDosen.getCboJenisKelamin().addItem("P"); 
    }
    
    public void insert(){
        dosen = new Dosen();
        dosen.setNip(formDosen.getTxtNip().getText());
        dosen.setNama(formDosen.getTxtNama().getText());
        dosen.setAlamat(formDosen.getTxtAlamat().getText());
        dosen.setJenisKelamin(formDosen.getCboJenisKelamin().getSelectedItem().toString());
        dosen.setTgllahir(formDosen.getTxtTanggalLahir().getText());
        dosenDao.insert(dosen);
        JOptionPane.showMessageDialog(formDosen, "Entri Data Ok");
    }
    
    public void getDosen(){
        int index = formDosen.getTabelDosen().getSelectedRow();
        dosen = dosenDao.getDosen(index);
        if(dosen != null){
            formDosen.getTxtNip().setText(dosen.getNip());
            formDosen.getTxtNama().setText(dosen.getNama());
            formDosen.getTxtAlamat().setText(dosen.getAlamat());
            formDosen.getCboJenisKelamin().setSelectedItem(dosen.getJenisKelamin());
            formDosen.getTxtTanggalLahir().setText(dosen.getTgllahir());
        }else{
            JOptionPane.showMessageDialog(formDosen, "Mahasiswa Tidak Ada");
        }
    }
    
    public void viewData(){
        DefaultTableModel tableModel = (DefaultTableModel)formDosen.getTabelDosen().getModel();
        tableModel.setRowCount(0);
        List<Dosen> data = dosenDao.getAllDosen();
        for(Dosen dsn : data) {
            Object[] row = {
                dsn.getNip(),
                dsn.getNama(),
                dsn.getAlamat(),
                dsn.getJenisKelamin(),
                dsn.getTgllahir()
            };
            tableModel.addRow(row);
        }
    }
    
    public void update(){
        dosen.setNip(formDosen.getTxtNip().getText());
        dosen.setNama(formDosen.getTxtNama().getText());
        dosen.setAlamat(formDosen.getTxtAlamat().getText());
        dosen.setJenisKelamin(formDosen.getCboJenisKelamin().getSelectedItem().toString());
        dosen.setTgllahir(formDosen.getTxtTanggalLahir().getText());
        dosenDao.update(index, dosen);
        JOptionPane.showMessageDialog(formDosen, "Update Data Ok");
    }
    
    public void delete(){
        dosenDao.delete(index);
        JOptionPane.showMessageDialog(formDosen, "Delete Data Ok");
    }

    private static class dosenDao {

        public dosenDao() {
        }
    }
}
