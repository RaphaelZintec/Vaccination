package intecbrussel.be;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class AnimalShelter{
    //ATTRIBUTES
        private List<Animal> animals = new ArrayList<>();
        private static int animalId; //static om dezelfde waarde te delen


    //CONSTRUCTORS
        public AnimalShelter(){}
        public AnimalShelter(int animalId) {
            this.animalId = animalId;
        }


    //METHODES
        public void printAnimals(){
            animals.forEach(a-> System.out.println("\t"+a));
        }
        public void sortAnimals(){ // hier gebruik ik compareTo() sorteert de dieren volgens hun natuurlijke volgorde, dit is volgens hun animalNumber
            Collections.sort(animals); //compareTo() bij ID
        }
        public void sortAnimalsByName(){
            animals.sort(Comparator.comparing(Animal::getName));
        }
        public void sortAnimalsByAge(){
            Collections.sort(animals, Comparator.comparing(Animal::getAge));
        }
        public void printAnimalsNotVaccinated(Disease disease){
            animals.forEach(a->{
                if(a.getVaccinationMap().containsKey(disease)){
                    if (!a.getVaccinationMap().get(disease)){
                        System.out.println("\t"+a);
                    }
                }
            });
        }
        public Optional<Animal> findAnimal(int animalNumber){
            if(animals.stream().anyMatch(a->a.getAnimalNumber()==animalNumber))
                    return animals.stream().filter(a->a.getAnimalNumber()==animalNumber).findFirst();
            else
                return Optional.empty();
        }
        public Optional<Animal> findAnimal(String name){
            if(animals.stream().anyMatch(a->a.getName().equals(name)))
                return animals.stream().filter(a->a.getName().equals(name)).findFirst();
            else
                return Optional.empty();
        }
        public void treatAnimal(int animalNumber){ //Mag uitzondering veroorzaken als vind niet de nummer
            try {
                animals.stream().filter(a -> a.getAnimalNumber() == animalNumber).findFirst().get().treatAnimal();
                System.out.println("\t"+animals.stream().filter(a->a.getAnimalNumber() == animalNumber).findFirst().get());
            } catch (NoSuchElementException e){
                System.out.println("\t\uD83D\uDD34 Het dier met deze id bestaat hier niet");
            }
        }
        public void treatAnimal(String name) { //Mag uitzondering veroorzaken als vind niet de id
            try {
                animals.stream().filter(a -> a.getName().equals(name)).findFirst().get().treatAnimal();
                System.out.println("\t" + animals.stream().filter(a -> a.getName().equals(name)).findFirst().get());
            } catch (NoSuchElementException e){
                System.out.println("\t\uD83D\uDD34 Het dier met deze naam bestaat hier niet");
            }
        }
        public void treatAllAnimals(){
            animals.forEach(Animal::treatAnimal);
        }
        public void vaccinateAllAnimals(Disease disease){
            animals.forEach(a->a.vaccinateAnimal(disease));
        }
        public void vaccinateOneAnimal(String name, Disease disease) throws NoSuchElementException{ //veroorzaak een uitzondering als vind de naam niet
            animals.stream().filter(a -> a.getName().equals(name)).findFirst().get().vaccinateAnimal(disease);
            System.out.println("\t" + animals.stream().filter(a -> a.getName().equals(name)).findFirst().get());
        }
        public Optional<Animal> findOldestAnimal(){
            if(animals.stream().max(Comparator.comparing(Animal::getAge)).isPresent())
                return animals.stream().max(Comparator.comparing(Animal::getAge));
            else
                return Optional.empty();
        }
        public int countAnimals(){return (int)animals.stream().count();} //return long dus casting nodig, animals.size() ook goed
        public void addAnimal(Animal animal){
            animal.setAnimalNumber(++animalId);
            animals.add(animal);
        }

}
