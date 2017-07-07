/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import business.Person;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author johns
 */
public class TreeMapSortUtil {
    public static TreeMap<String, Person> 
    sortByLastName(final TreeMap<String, Person> map) {
    Comparator<String> valueComparator = 
             new Comparator<String>() {
      public int compare(String k1, String k2) {
        int compare = 
              map.get(k1).getLastName().toLowerCase().compareTo(map.get(k2).getLastName().toLowerCase());
        if (compare == 0) 
          return 1;
        else 
          return compare;
      }
    };
 
    TreeMap<String, Person> sortedByValues = new TreeMap<String, Person>(valueComparator);
    sortedByValues.putAll(map);
    return sortedByValues;
  }

}
