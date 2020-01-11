package output;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Checker {
	
	BufferedReader fr;
	
	public String[] getCsv() {
		ArrayList<String> list= new ArrayList<>();
		try {
			fr = new BufferedReader(new FileReader(new File("C:/Users/Julian/git/Birthday_Alert_System/resources/birthdays.csv")));
			String line = "";
			while((line = fr.readLine()) != null)
				list.add(line);
			String[] result = new String[list.size()];
			for(int i =0; i< list.size(); i++)
				result[i] = list.get(i);
			return result;	
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public ArrayList<String> getBirthdayPeople()  {
		ArrayList<String> result = new ArrayList<>();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM");
		Date birthday;
		for(String line: getCsv()) {
			String[] parted = line.split(";");
			try {
			if(sdf.format(today).equals(parted[1])) {
				result.add(parted[0]);
			}
			}
			catch(Exception e) {
			}
		}
		return result;
	}
}
