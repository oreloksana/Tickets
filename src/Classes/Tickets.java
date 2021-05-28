package Classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.util.HashMap;
public class Tickets {
 private static double ticketPrice;
 private static HashMap<String, Double> ticketsTypes = new HashMap<String, Double>();
 public static ObservableList<String> ticketsType = FXCollections.observableArrayList();
 public Tickets() {
  ticketsTypes.put("Zone M ", 3.40 );
  ticketsTypes.put("Zone M - 1 ", 5.10 );
  ticketsTypes.put("Zone M - 2 ", 6.80 );
  ticketsTypes.put("Zone M - 3 ", 8.50 );
  ticketsTypes.put("Zone M - 4 ", 10.20 );
  ticketsTypes.put("Zone M - 5 ", 11.90 );
  ticketsTypes.put("Zone M - 6 ", 13.60 );
 }

 public static ObservableList<String> givePossibleTickets() {
  for (String i : ticketsTypes.keySet()) {
   ticketsType.add("Ticket " + i + " price: " + ticketsTypes.get(i) + " € ");
  }
  return ticketsType;
 }

 public static double getPrice(String i){
  ticketPrice = ticketsTypes.get(i);
  return ticketPrice;
 }


}
