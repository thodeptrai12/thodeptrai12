/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.UnsupportedEncodingException;
import java.text.Normalizer;

/**
 *
 * @author ASUS
 */
class Helper {

    public static String unicodeToASCII(String s) {
        String s1 = Normalizer.normalize(s, Normalizer.Form.NFKD);
        String regex
                = "[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+";
        String s2 = null;
        try {
            s2 = new String(s1.replaceAll(regex, "").getBytes("ascii"),
                    "ascii");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
        return s2;
    }
}
