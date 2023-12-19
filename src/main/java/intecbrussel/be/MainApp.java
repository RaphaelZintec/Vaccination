package intecbrussel.be;

import java.util.NoSuchElementException;
import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        //INITIALISEREN
        AnimalShelter animalShelter = new AnimalShelter(0); // begin vanaf nul
        String[] names = {"Whiskers", "Rafiki", "Tom", "Snoopy", "Mojo", "Max", "Samba", "Felix", "Rex", "Cheeky"};
        Random random = new Random();
        for (String name : names){
            switch (random.nextInt(3)){
                case 0 : animalShelter.addAnimal(new Cat(false, random.nextInt(15)+1, name, true)); break;
                case 1 : animalShelter.addAnimal(new Dog(false, random.nextInt(15)+1, name, true)); break;
                case 2 : animalShelter.addAnimal(new Monkey(false, random.nextInt(50)+1, name, true));
            }
        }

        //GEBRUIKEN ALLE METHODES
        System.out.println("\n\uD83D\uDFE2 1 Aantal dieren: "+animalShelter.countAnimals());

        System.out.println("\n\uD83D\uDFE2 2 Oudste dier: ");
        System.out.println("\t"+animalShelter.findOldestAnimal().orElse(new Animal.UnknownAnimal())); //stuur object van Unknown-klasse met nul waarden als niks vind

        System.out.println("\n\uD83D\uDFE2 3 Sorteer dieren volgens natuurlijke volgorde bij ID: ");
        animalShelter.sortAnimals();
        animalShelter.printAnimals();

        System.out.println("\n\uD83D\uDFE2 4 Sorteer dieren volgens de naam A-Z: ");
        animalShelter.sortAnimalsByName();
        animalShelter.printAnimals();

        System.out.println("\n\uD83D\uDFE2 5 Sorteer dieren volgens de leeftijd 0-99: ");
        animalShelter.sortAnimalsByAge();
        animalShelter.printAnimals();

        System.out.println("\n\uD83D\uDFE2 6 Vind dier bij id:");
        System.out.println("\t"+animalShelter.findAnimal(9).orElse(new Animal.UnknownAnimal()));  //stuur object van Unknown-klasse met nul waarden als niks vind

        System.out.println("\n\uD83D\uDFE2 7 Vind dier bij de naam:");
        System.out.println("\t"+animalShelter.findAnimal("Felix").orElse(new Animal.UnknownAnimal())); //stuur object van Unknown-klasse met nul waarden als niks vind

        System.out.println("\n\uD83D\uDFE2 8 Behandelen dieren bij naam:");
        animalShelter.treatAnimal("Snoopy");

        System.out.println("\n\uD83D\uDFE2 9 Behandel dieren bij id:");
        animalShelter.treatAnimal(2);

        System.out.println("\n\uD83D\uDFE2 10 Afdrukken dieren die niet gevaccineerd zijn voor een ziekte:");
        animalShelter.printAnimalsNotVaccinated(Disease.CHICKENPOCKS);

        System.out.println("\n\uD83D\uDFE2 11 Behandel alle dieren:");
        animalShelter.treatAllAnimals();
        animalShelter.printAnimals();

        System.out.println("\n\uD83D\uDFE2 12 Vaccineer een dier voor een bepaalde ziekte:");
        try{ //andere manier voor try/catch met throws
            animalShelter.vaccinateOneAnimal("Rex", Disease.POLIO);
        } catch (NoSuchElementException e){System.out.println("\t\uD83D\uDD34 Het dier met deze naam bestaat hier niet");}

        System.out.println("\n\uD83D\uDFE2 13 Vaccineer alle dieren voor een bepaalde ziekte:");
        animalShelter.vaccinateAllAnimals(Disease.FLUE);
        animalShelter.printAnimals();
    }
}
