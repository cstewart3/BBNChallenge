import java.time.LocalDate;

/**
 * This class defines a meeting duration object
 * A meeting duration object contains a start date, an end date,
 * the frequency of the meeting, and the day of the week the meeting
 * occurs on
 * 
 * This class should be used to define a meeting that occurs on a certain day
 * between two specific dates
 * @author Charlie Stewart
 *
 *DAYS OF WEEK:
 *1 - Monday
 *2 - Tuesday
 *3 - Wednesday
 *4 - Thursday
 *5 - Friday
 *6 - Saturday
 *7 - Sunday
 */
public class MeetingDuration {
	private LocalDate start;
	private LocalDate end;
	private int freq;
	private int dayOfMeeting;

	/**
	 * Constructor for MeetingDuration
	 * @param start  start date for meeting duration
	 * @param end  end date for meeting duratiton
	 * @param freq  frequency of the meeting
	 * @param dayOfMeeting  day of week the meeting occurs on
	 */
	public MeetingDuration(LocalDate start, LocalDate end, int freq, int dayOfMeeting){
		this.start = start;
		this.end = end;
		this.freq = freq;
		this.dayOfMeeting = dayOfMeeting;
	}

	/**
	 * Gets the start date for a meeting duration
	 * @return  start date
	 */
	public LocalDate getStart(){
		return start;
	}


	/**
	 * Gets the end date for a meeting duration
	 * @return  end date
	 */
	public LocalDate getEnd(){
		return end;
	}


	/**
	 * Gets the frequency of a meeting duration
	 * @return  frequency
	 */
	public int getFreq(){
		return freq;
	}

	/**
	 * Gets the day of the week a meeting occurs on
	 * @return day of meeting
	 */
	public int getDay(){
		return dayOfMeeting;
	}

	/**
	 * Converts a day of type int into a string representation
	 * @param day  day in int form
	 * @return  day in string form
	 */
	public String getDayStr(int day){

		if(day == 1)
			return "Monday";
		else if(day == 2)
			return "Tuesday";
		else if(day == 3)
			return "Wednesday";
		else if(day == 4)
			return "Thursday";
		else if(day == 5)
			return "Friday";
		else if(day == 6)
			return "Saturday";
		else if(day == 7)
			return "Sunday";
		else
			return "Invalid Day (1-7 only)";

	}



}
