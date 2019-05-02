import TaskApp.TaskPOA;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskWorker extends TaskPOA {

    private List<Character> characterList;

    public void createList() {
        int size = 100;
        characterList = new ArrayList<Character>(100);

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            final String ALPHABET = "abcdefghijklmnopqrsuvwxyz";
            characterList.add(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
            System.out.println(characterList.get(i));
        }
    }

    public String getVowels() {
        StringBuilder result = new StringBuilder();
        if (characterList == null) {
            createList();
        }

        for (char character : characterList) {
            if (isVowel(character)) {
                result.append(character).append('\n');
            }
        }

        return String.valueOf(result);
    }

    private boolean isVowel(char c) {
        final String VOWELS = "aeiouqy";
        return VOWELS.contains(String.valueOf(c));
    }
}


