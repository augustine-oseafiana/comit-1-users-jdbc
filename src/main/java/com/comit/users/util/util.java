package com.comit.users.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class util {
    
	
	public static int parseId(String id) {
		 return (id==null)? 0:Integer.parseInt(id);
   }
	
	public static Date parseDate(String str) {
	    Date date = null;
	    
	   try {
		date = new SimpleDateFormat("yyyy-MM-dd").parse(str.trim());
	} catch (ParseException e) {
		throw new RuntimeException("Error while paring date: " + str);
	}
	    
	    return date;
	}
}
