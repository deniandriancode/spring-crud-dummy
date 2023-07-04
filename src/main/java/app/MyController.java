package app;

import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
public class MyController {

    @Autowired
    public MyData data;

    @GetMapping("/")
    public String getHome() {
        return "<h1>Well Hello There!</h1>";
    }

    @GetMapping("/guest")
    public List<Guest> getAllGuests() {
        return data.guestList;
    }

    @GetMapping("/guest/find")
    public List<Guest> getGuestByName(@RequestParam(value = "name", defaultValue = "") String name) {
        List<Guest> result = new ArrayList<>();
        if (name.trim().length() == 0) {
            return data.guestList;
        }

        for (Guest guest : data.guestList) {
            if (guest.name.toLowerCase().contains(name.toLowerCase())) {
                result.add(guest);
            }
        }
        return result;
    }

    @PostMapping(path = "/guest/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean addGuest(@RequestBody Guest guest) {
        boolean result = false;
        if (guest == null) {
            return result;
        }

        data.guestList.add(guest);
        result = true;

        return result;
    }

    @PutMapping(path = "/guest/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateGuestByName(@RequestParam(value = "name", defaultValue = "") String name, @RequestBody Guest guest) {
        boolean result = false;
        if (name.trim().length() == 0 || guest == null) {
            return result;
        }

        for (int i = 0; i < data.guestList.size(); ++i) {
            Guest currentGuest = data.guestList.get(i);
            if (currentGuest.name.equalsIgnoreCase(name)) {
                data.guestList.set(i, guest);
                result = true;
            }
        }

        return result;
    }

    @DeleteMapping("/guest/deleteOne")
    public boolean deleteGuestByName(@RequestParam(value = "name", defaultValue = "") String name) {
        boolean result = false;
        if (name.trim().length() == 0) {
            return result;
        }

        for (int i = 0; i < data.guestList.size(); ++i) {
            Guest guest = data.guestList.get(i);
            if (guest.name.equalsIgnoreCase(name)) {
                data.guestList.remove(i);
                return true;
            }
        }


        return result;
    }

    @DeleteMapping("/guest/deleteMany")
    public boolean deleteAllGuestsByName(@RequestParam(value = "name", defaultValue = "") String name) {
        boolean result = false;
        if (name.trim().length() == 0) {
            return result;
        }

        for (int i = 0; i < data.guestList.size(); ++i) {
            Guest guest = data.guestList.get(i);
            if (guest.name.equalsIgnoreCase(name)) {
                data.guestList.remove(i);
                result = true;
            }
        }

        return result;
    }

}
