import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Implementation of the basic MeetingCounter interface
 * @author Charlie Stewart
 *
 */
public class SimpleMeetingCount implements MeetingCounterBasic {
	public ArrayList<LocalDate> holiday;
	public ArrayList<LocalDate> vacation;
	
	
	/**
	 * Constructor for implementation of meeting counter, takes in a list of holidays
	 * and vacations
	 * @param h  arraylist of holidays
	 * @param v  arraylist of vacation
	 */
	public SimpleMeetingCount(ArrayList<LocalDate> h, ArrayList<LocalDate> v){
		holiday = h;
		vacation = v;
	}
	
	
	@Override
	/**
	 * Implementation of numMeetings
	 * Loops through dates 
	 */
	public int CountMeetings(MeetingDuration m) {
		
		int mCount = 0;
		int mDay = m.getDay();
		LocalDate start = m.getStart();
		LocalDate end = m.getEnd();

		for (LocalDate day = start; day.isBefore(end); day = day.plusDays(1)) {
			int dayVal = day.getDayOfWeek().getValue();
			if(mDay == dayVal && !holiday.contains(day) && !vacation.contains(day)){
	
				mCount++;
			}
		}

		return mCount / m.getFreq();
	}
	

	public static void main(String[] args) {
		ArrayList<LocalDate> hDay = new ArrayList<LocalDate>();
		ArrayList<LocalDate> vDay = new ArrayList<LocalDate>();
		
		SimpleMeetingCount SM = new SimpleMeetingCount(hDay, vDay);
		
		MeetingDuration m1 = new MeetingDuration(LocalDate.of(2019, 1, 1), LocalDate.of(2019, 12, 31), 1, 1);
		
		System.out.println("Number of Meetings in 2019 on " +m1.getDayStr(m1.getDay()) + ": "+ SM.CountMeetings(m1));
		

		
	}

	

}
