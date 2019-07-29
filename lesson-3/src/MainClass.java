
import java.lang.reflect.Array;
import java.util.*;

public class MainClass {
    /*

	 1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
	  - Написать метод, который найдёт список слов, из которых состоит текст (дубликаты не считать);
	  - Написать метод, который посчитает сколько раз встречается каждое слово;

	 2. Написать простой класс PhoneBook:
	  - В качестве ключа использовать фамилию
	  - В каждой записи всего два поля: phone, e-mail
	  - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов),
	  и отдельный метод для поиска e-mail по фамилии.

	  Следует учесть, что под одной фамилией может быть несколько записей.
	  Итого должно получиться 3 класса Main, PhoneBook, Person.

    * */
    private static final String[] words = {"asd","asd","asd","zxc","zxc"};

    public static void main(String[] args) {
        System.out.println(filteredWordList(words));
        System.out.println(countWords(words));
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Saenko", "08080980988","SAENKOMAIL-1");
        phoneBook.add("Saenko", "08009833988","SAENKOMAIL-2");
        System.out.println("Saenko phone: "+phoneBook.getPhones("Saenko"));
        System.out.println("Saenko mail: "+phoneBook.getEmails("Saenko"));
        System.out.println("Jotaro mail: " + phoneBook.getPhones("Jotaro"));
        System.out.println("Majira phone: " + phoneBook.getPhones("Majira"));
    }

    private static HashSet<String> filteredWordList(String[] list) {
        return new HashSet<>(Arrays.asList(list));
    }
    private static HashMap<String, Integer> countWords (String[] list){
        HashMap<String, Integer> answer = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            String word = list[i];
            answer.put(word, (answer.containsKey(word))?answer.get(word)+1:1);
        }
        return answer;
    }



}
