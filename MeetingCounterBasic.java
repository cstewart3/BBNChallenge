
/**
 * A very basic single method interface that contains a method that counts the number
 * of meetings given a meeting duration object
 * This interface should be used if you only need to calculate meeting occurrences
 * for a single instance
 * @author Charlie Stewart
 *
 */
public interface MeetingCounterBasic {

	/**
	 * This method will allow for the number of meetings to be counted given a
	 * meeting duration object
	 * @param m meeting duration object
	 * @return number of occurrences of a meeting
	 */
	public int CountMeetings(MeetingDuration m);

}
