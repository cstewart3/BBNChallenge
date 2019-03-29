import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Implementation of MeetingCounter Interface
 * @author Charlie Stewart
 *
 */
public class MeetingCounts2019 implements MeetingCounter{

	public ArrayList<LocalDate> holiday;
	public ArrayList<LocalDate> vacation;
	public Stack<MeetingDuration> meetings;


	/**
	 * Constructor for implementation of meeting counter, takes in a list of holidays, a list of vacations 
	 * and a stack of meeting duration objects
	 * @param h  arraylist of holidays
	 * @param v  arraylist of vacation
	 * @param m  stack of MeetingDurations
	 */
	public MeetingCounts2019(ArrayList<LocalDate> h, ArrayList<LocalDate> v, Stack<MeetingDuration> m){
		holiday = h;
		vacation = v;
		meetings = m;

	}

	@Override
	/**
	 * Implementation of numMeetings
	 * Loops through dates 
	 */
	public int numMeetings(MeetingDuration m) {

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


	@Override
	/**
	 * Implementation of dayDiff, difference between two meeting durations
	 */
	public int dayDiff(MeetingDuration m1, MeetingDuration m2) {

		return numMeetings(m2) - numMeetings(m1);
	}


	@Override
	/**
	 * Simple implementation of totalDays
	 */
	public int totalDays(Stack<MeetingDuration> meetingDays) {
		int total = 0;

		while(!meetings.isEmpty()){
			total += numMeetings(meetings.pop());
		}

		return total;
	}


	public static void main (String[] args){

		ArrayList<LocalDate> hDay = new ArrayList<LocalDate>();
		ArrayList<LocalDate> vDay = new ArrayList<LocalDate>();
		Stack<MeetingDuration> mDays = new Stack<MeetingDuration>();

		hDay.add(LocalDate.of(2019, 1, 1));
		hDay.add(LocalDate.of(2019, 1, 21));
		hDay.add(LocalDate.of(2019, 2, 18));
		hDay.add(LocalDate.of(2019, 5, 27));
		hDay.add(LocalDate.of(2019, 4, 7));
		hDay.add(LocalDate.of(2019, 9, 2));
		hDay.add(LocalDate.of(2019, 10, 14));
		hDay.add(LocalDate.of(2019, 11, 11));
		hDay.add(LocalDate.of(2019, 11, 28));
		hDay.add(LocalDate.of(2019, 12, 25));

		MeetingDuration m3 = new MeetingDuration(LocalDate.of(2019, 1, 1), LocalDate.of(2019, 12, 31), 1, 1);
		MeetingDuration m4 = new MeetingDuration(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 12, 31), 1, 4);

		mDays.push(m3);
		mDays.push(m4);

		MeetingCounts2019 M = new MeetingCounts2019(hDay, vDay, mDays);
		MeetingDuration m1 = new MeetingDuration(LocalDate.of(2019, 1, 1), LocalDate.of(2019, 12, 31), 1, 1);
		MeetingDuration m2 = new MeetingDuration(LocalDate.of(2019, 1, 1), LocalDate.of(2019, 12, 31), 1, 2);


		System.out.println("Number of Meetings in 2019 on " +m1.getDayStr(m1.getDay()) + ": "+ M.numMeetings(m1));

		System.out.println("There would be time for " + M.dayDiff(m1, m2) + " meetings on " + m2.getDayStr(m2.getDay())  + " instead of " + m1.getDayStr(m1.getDay()));


		System.out.println(M.totalDays(mDays));
	}


}
