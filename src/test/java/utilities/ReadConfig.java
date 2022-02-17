package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties p;
	public ReadConfig()
	{
		File f= new File("./Configuration/config.properties");
		try
		{
			FileInputStream fi = new FileInputStream(f);
			p= new Properties();
			p.load(fi);
		}
		catch(Exception e)
		{
			System.out.println("Exception is--"+e.getMessage());
		}
	}
	public String getAppUrl()
	{
		String url=p.getProperty("baseurl");
		return url;
	}
	public String getUserName()
	{
		String username= p.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password= p.getProperty("password");
		return password;
	}

}
