import java.util.Stack;


/**
 * Interface that should be used when calculating specific occurrences of meeting
 * This interface takes into account vacations, holidays, as well as changing the 
 * day of the meeting
 * @author Charlie Stewart
 *
 */
public interface MeetingCounter {

	/**
	 * This method will allow for the number of meetings to be counted given a
	 * meeting duration object
	 * @param m meeting duration object
	 * @return number of occurrences of a meeting
	 */
	public int numMeetings(MeetingDuration m);

	/**
	 * Calculates the difference in meeting occurrences given to meeting duration objects
	 * @param m1 first meeting duration
	 * @param m2  second meeting duration
	 * @return  difference in number of days between the two meeting durations
	 */
	public int dayDiff(MeetingDuration m1, MeetingDuration m2);


	/**
	 * Calculates the total amount of days given multiple different meeting duration objects
	 * @param meetings A stack of meeting duration objects
	 * @return sum of occurrences of all meeting duration objects on the meetings stack
	 */
	public int totalDays(Stack<MeetingDuration> meetings);

}
