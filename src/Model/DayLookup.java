/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class DayLookup {
    
    private LocalDate date;
    private HashMap<String, Integer> words;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public HashMap<String, Integer> getWords() {
        return words;
    }

    public void setWords(HashMap<String, Integer> words) {
        this.words = words;
    }


    
}
