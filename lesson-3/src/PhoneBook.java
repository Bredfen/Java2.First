import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class PhoneBook {
    private final HashMap<String, ArrayList<Person>> notes = new HashMap<>();

    public void add(String surname, String phone, String email){
        if (notes.containsKey(surname)){
            notes.get(surname).add(new Person(phone, email));
        } else {
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(new Person(phone, email));
            notes.put(surname, persons);
        }
    }
    public ArrayList<String> getEmails(String surname){
        return (notes.containsKey(surname))?notes.get(surname).stream().map(person -> person.email).collect(Collectors.toCollection(ArrayList::new)):null;
    }
    public ArrayList<String> getPhones(String surname){
        return (notes.containsKey(surname))?notes.get(surname).stream().map(person -> person.phone).collect(Collectors.toCollection(ArrayList::new)):null;
    }
}
