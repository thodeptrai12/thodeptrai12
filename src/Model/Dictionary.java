/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
/**
 *
 * @author ASUS
 */
public class Dictionary {

    private RecordWord<String, String> Anh_Viet;
    private RecordWord<String, String> Viet_Anh;
    public static RecordWord<String, String> listFavoriteWordEnglish;
    public static RecordWord<String, String> listFavoriteWordVietnamese;
    public static RecordWord<String, String> listNewWordAnh_Viet;
    public static RecordWord<String, String> listNewWordViet_Anh;
    public static List<DayLookup> listSearch;
    
    
    
//    Getter and Setter
    public RecordWord getAnh_Viet() {
        return Anh_Viet;
    }

    public void setAnh_Viet(RecordWord Anh_Viet) {
        this.Anh_Viet = Anh_Viet;
    }

    public RecordWord getViet_Anh() {
        return Viet_Anh;
    }

    public void setViet_Anh(RecordWord Viet_Anh) {
        this.Viet_Anh = Viet_Anh;
    }

}
