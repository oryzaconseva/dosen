/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oryzac16.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ORYZA CONSEVA
 */
public class DosenDao {
    private List<Dosen> data = new ArrayList<Dosen>();
    
    public DosenDao() {
        data.add(new Dosen("19810415 ", "Rayhan", "Sawahlunto", "L", "01-09-2000"));
        data.add(new Dosen("19810416 ", "Ghiffar", "Jakarta", "L", "10-12-2000"));
        data.add(new Dosen("19810417 ", "Rahmi", "Padang", "P", "25-09-2000"));
    }

    public void insert (Dosen m){
        data.add(m);
    }
    
    public void update(int index,Dosen m){
        data.set(index,m);
    }
    
    public void delete(int index){
        data.remove(index);
    }
    
    public Dosen getDosen(int index){
        return data.get(index);
    }
    
    public List<Dosen> getAllDosen(){
        return data;
    }
}
