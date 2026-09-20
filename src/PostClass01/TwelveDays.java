package PostClass01;

import java.util.Locale;
import java.util.ResourceBundle;

public class TwelveDays {
	
	static ResourceBundle bundle = ResourceBundle.getBundle
			("PostClass01.messages", Locale.of("vi"));
	
	public static void main(String[] args) {
		for (int i = 0; i < 12; i++) {
			DAYS[i] = bundle.getString("day." + i);
			GIFTS[i] = bundle.getString("gift." + i);
		}
		System.out.println(poem());
	}
	
	static String[] DAYS = new String[12];
	
	static String[] GIFTS = new String[12];
	
	/*
     * Returns the first line in the verse for a given day.
	 */
	static String firstLine(int day) {
	  return bundle.getString("text.on_the")
			  + DAYS[day] + bundle.getString("text.day_of");
	}
	
	/*
     * Returns a string that lists all the gifts received on a given
     * day.
	 */
	static String allGifts(int day) {
		if (day == 0) { 
			return bundle.getString("text.and") + GIFTS[0]; 
		}
		else { 
			return GIFTS[day] + "\n" + allGifts(day-1);	
		}
	}
	
	/*
	 * Returns the text of the entire poem. 
	 */
	static String poem() {
		String poem = firstLine(0) + GIFTS[0] + "\n\n";
		for (int day = 1; day < 12; day++) { 
			poem += firstLine(day) + allGifts(day) + "\n\n"; 
		}
		return poem;
	}
}