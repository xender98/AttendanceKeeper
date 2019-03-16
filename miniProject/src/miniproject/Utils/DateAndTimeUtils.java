package miniproject.Utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaydutt
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTimeUtils {
    
    public static String getDate()
    {
        LocalDateTime current = LocalDateTime.now();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return current.format(dateFormatter);
    }
    
    public static String getTime()
    {
        LocalDateTime current = LocalDateTime.now();
        
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:MM");
	return current.format(timeFormatter);
    }
    
}
