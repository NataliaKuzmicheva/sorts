import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket o1, Ticket o2) {
        int flightTime1 = o1.getTimeTo() - o1.getTimeFrom();
        int flightTime2 = o2.getTimeTo() - o2.getTimeFrom();
        if (flightTime1 < flightTime2) {
            return -1;
        } else if (flightTime1 > flightTime2) {
            return 1;
        } else
            return 0;
    }
}


//    @Override
//    public int compare(Ticket t1, Ticket t2) {
//        if ()
//        // ваш код
//    }
//}
//
//public int compareTo(Ticket o) {
//    if (this.price < o.price) {
//        return -1;
//    } else if (this.price > o.price) {
//        return 1;
//    } else {
//        return 0;
//    }
//}