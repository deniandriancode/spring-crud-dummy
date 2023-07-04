package app;

import java.util.*;
import org.springframework.stereotype.*;

@Component
public class MyData {

    public List<Guest> guestList = new ArrayList<>();

    public MyData() {
        guestList.add(new Guest("John Doe", 24, "Web Developer"));
        guestList.add(new Guest("Jane Doe", 22, "Front End Developer"));
        guestList.add(new Guest("Bard Tuck", 26, "Back End Developer"));
        guestList.add(new Guest("Bryan", 25, "Cybersecurity"));
        guestList.add(new Guest("Smith", 28, "Technical Support"));
    }

}
