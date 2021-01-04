
package in.co.sunrays.proj4.util;

import java.util.Date;

/**
 * This class validates input data
 * 
 * @author SunilOS
 * @version 1.0
 * @Copyright (c) SunilOS
 */

public class DataValidator1 {

    /**
     * Checks if value is Null
     * 
     * @param val
     * @return
     */
    public static boolean isNull(String val) {
        if (val == null || val.trim().length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if value is NOT Null
     * 
     * @param val
     * @return
     */
    public static boolean isNotNull(String val) {
        return !isNull(val);
    }

    /**
     * Checks if value is an Integer
     * 
     * @param val
     * @return
     */

    public static boolean isInteger(String val) {

        if (isNotNull(val)) {
            try {
                int i = Integer.parseInt(val);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }

        } else {
            return false;
        }
    }

    /**
     * Checks if value is Long
     * 
     * @param val
     * @return
     */
    public static boolean isLong(String val) {
        if (isNotNull(val)) {
            try {
                long i = Long.parseLong(val);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }

        } else {
            return false;
        }
    }

    /**
     * Checks if value is valid Email ID
     * 
     * @param val
     * @return
     */
    public static boolean isEmail(String val) {

        String emailreg = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        if (isNotNull(val)) {
            try {
                return val.matches(emailreg);
            } catch (NumberFormatException e) {
                return false;
            }

        } else {
            return false;
        }
    }
    
    
    
    
    public static boolean isCourse(String val) {

        String coursereg = "^[A-Z]+(\\.[A-Za-z]+)*$";

        if (isNotNull(val)) {
            try {
                return val.matches(coursereg);
            } catch (NumberFormatException e) {
                return false;
            }

        } else {
            return false;
        }
    }
    
    
    
    public static boolean isSubject(String val) {

        String subreg = "^[A-Z_a-z_][\\s(A-Za-z_0-9)]*$";

        if (isNotNull(val)) {
            try {
                return val.matches(subreg);
            } catch (NumberFormatException e) {
                return false;
            }

        } else {
            return false;
        }
    }
    
    
    
	/*
	 * public static boolean isDescription(String val) {
	 * 
	 * String desreg = "([0-9]{2,})+(\\s[A-Za-z]{2,})";
	 * 
	 * if (isNotNull(val)) { try { return val.matches(desreg); } catch
	 * (NumberFormatException e) { return false; }
	 * 
	 * } else { return false; } }
	 */
    
    /**
     * Checks if value is valid First Name
     * 
     * @param val
     * @return
     */
   public static boolean isFname(String val) 
    {
		
    	String fnamereg = "^[a-zA-Z_-]+$";
    	if(isNotNull(val))
    	{
    		try
    		{
    			return val.matches(fnamereg);
    		}
    		catch(Exception e)
    		{
    			return false;
    		}
    	}
    		else
    		{
    			return false;
    		}
	}
   
   /**
    * Checks if value is valid Last Name
    * 
    * @param val
    * @return
    */
    public static boolean isLname(String val) 
    {
		
    	String lnamereg = "^[a-zA-Z_-]+$";
		if(isNotNull(val))
		{
			try
			{
				return val.matches(lnamereg);
			}
			catch (Exception e) 
			{
				return false;
			}
		}
		else 
		{
			return false;
		}
	}
    
    /**
     * Checks if value is valid Mobile Number
     * 
     * @param val
     * @return
     */
    public static boolean isMobileNo(String val) {
		String moreg =  "^[6-9][0-9]{9}$";
		if(isNotNull(val))
		{
			try
			{
				return val.matches(moreg);
			}
			catch(Exception e)
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
    
    /**
     * Checks if value is valid Password
     * 
     * @param val
     * @return
     */
    public static boolean isPassword(String val) {
    	String passreg = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";
    	if(isNotNull(val))
    	{
    		try
    		{
    			return val.matches(passreg);
    		}
    		catch (Exception e) 
    		{
				return false;
			}
    	}
    	else 
    	{
    		return false;
    	}
		
	}
   
    public static boolean isRollNo(String val) {
    	String rollreg="([0-9]{2,})+([A-Za-z]{2,})+([0-9]{2,})";
    	if(isNotNull(val)) {
    	try{
    		return val.matches(rollreg);
    	}
    	catch(Exception e) {
    		return false;
    	}
    	}else {
    		return false;
    	}
    }
    
	/*
	 * // validate address public static boolean isAddress( String val ){ String
	 * addreg = "[A-Za-z0-9'\\.\\-\\s\\,]"; if (isNotNull(val)) { try { return
	 * val.matches(addreg); } catch (Exception e) { // TODO: handle exception return
	 * false; } }else {
	 * 
	 * return false;
	 * 
	 * 
	 * }
	 * 
	 * }
	 */

    /**
     * Checks if value is Date
     * 
     * @param val
     * @return
     */
    public static boolean isDate(String val) {

        Date d = null;
        if (isNotNull(val)) {
            d = DataUtility1.getDate(val);
        }
        return d != null;
    }

    /**
     * Test above methods
     * 
     * @param args
     */
    public static void main(String[] args) {

        /*System.out.println("Not Null 2" + isNotNull("ABC"));
        System.out.println("Not Null 3" + isNotNull(null));
        System.out.println("Not Null 4" + isNull("123"));

        System.out.println("Is Int " + isInteger(null));
        System.out.println("Is Int " + isInteger("ABC1"));
        System.out.println("Is Int " + isInteger("123"));
        System.out.println("Is Int " + isNotNull("123"));*/
    	System.out.println(isRollNo("00s00"));
    	//System.out.println(isAddress(""));
    }

}