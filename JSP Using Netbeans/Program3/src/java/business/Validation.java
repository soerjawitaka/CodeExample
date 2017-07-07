/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author John_Soerjawitaka
 */
public class Validation {
    public static boolean isPresent(String text) {
        boolean isValid = false;
        if(!text.equals("") && text != null) {
            isValid = true;
        }
        return isValid;
    }
    
    public static boolean isDouble(String num) {
        boolean isValid = true;
        try {
            Double.parseDouble(num);
        }
        catch (NumberFormatException e) {
            isValid = false;
        }
        return isValid;
    }
}
