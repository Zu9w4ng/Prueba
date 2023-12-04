package mainPackage;

import java.util.Scanner;

@SuppressWarnings("resource")
public class Input {
    
    public static byte readByte(String message) throws Exception
    {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        byte b;
        try
        {
        	b = sc.nextByte();
        	return b;
        }
        catch (Exception e)
        {
        	sc.next();
        	throw e;
        }    
    }

    public static int readInt(String message) throws Exception
    {
        System.out.println(message);
		Scanner sc = new Scanner(System.in);
        int n;
        try
        {
        	n = sc.nextInt();
        	return n;
        }
        catch (Exception e)
        {
        	sc.next();
        	throw e;
        }       
    }

    public static float readFloat(String message) throws Exception
    {    
    	System.out.println(message);
    	Scanner sc = new Scanner(System.in);
        float f;
        try
        {
            f = sc.nextFloat();
            return f;
        }
        catch (Exception e)
        {
            sc.next();
            throw e;
        }         
    }

    public static double readDouble(String message) throws Exception
    {
        System.out.println(message);
		Scanner sc = new Scanner(System.in);
        double d;
        try
        {
        	d = sc.nextDouble();
        	return d;
        }
        catch (Exception e)
        {
        	sc.next();
        	throw e;
        }    
    }

    public static char readChar(String message) throws Exception
    {
    	System.out.println(message);
        Scanner sc = new Scanner(System.in);
        String character = sc.nextLine();
        
        if (character.length() != 1)
        	throw new Exception("A character was expected, incorrect length");
        
        return character.charAt(0);
    }

    public static String readString(String message)
    {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        
        return sc.nextLine();
    }

    public static boolean readYesNo(String message) throws Exception
    {
        char b = Input.readChar(message);
        
        if (b != 'y' && b != 'n')
        	throw new Exception("Use 'y' or 'n'");
        
        if (b == 'y')
        	return true;
        return false;
    }

}
