/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author ASUS
 * @param <T1>
 * @param <T2>
 */
public class RecordWord<T1, T2> {

    private HashMap<T1, T2> records = new HashMap<>();
    
    
    public HashMap<T1, T2> getRecords() {
        return records;
    }

    public void setRecords(HashMap<T1, T2> records) {
        this.records = records;
    }

    public void addRecord(T1 word, T2 meaning) {
        records.put(word, meaning);
    }
    
    public void removeRecord(T1 word){
        records.remove(word);
    }

    public T2 getMeaning(T1 word) {
        return records.get(word);
    }
    
    public boolean checkWord(T1 word){
        return records.containsKey(word);
    }
}
