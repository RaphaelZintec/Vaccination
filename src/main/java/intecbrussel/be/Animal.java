package intecbrussel.be;

import java.util.HashMap;
import java.util.Map;

public abstract class Animal implements Vaccinateable, Treatable, Comparable<Animal>{

    //NESTED CLASS als Optional return geen object dan ga ik deze object gebruiken met nul waarden
        public static class UnknownAnimal extends Animal{
            @Override
            public String toString() {
                return super.toString().replaceAll("ANIMAL", "\uD83D\uDC7D UNKOWN" + String.format("%-1s", "") );
            }
            @Override
            public void treatAnimal() {}
        }


    //ATTRIBUTES
        private Map<Disease, Boolean> isVaccinated = new HashMap<>(){{
            for (Disease disease : Disease.values()) //put alle ziekten
                put(disease, false);
        }};
        private boolean isClean;
        private int age;
        private String name;
        private int animalNumber;


    //CONSTRUCTORS
        public Animal(){}
        public Animal(boolean isClean, int age, String name) {
            this.isClean = isClean;
            this.age = age;
            this.name = name;
        }

    //METHODES
        public Map<Disease, Boolean> getVaccinationMap() { //voor de methode printAnimalsNotVaccinated
            return isVaccinated;
        }
        public void setAnimalNumber(int animalNumber) { //voor de methode addAnimal(Animal animal)
                this.animalNumber = animalNumber;
            }
        public int getAge() {  //voor findOldestAnimal() & sortAnimalsByAge()
            return age;
        }
        public void changeCleanStatus() { //voor treatAnimal()
            isClean = true;
        }
        public String getName() { //voor findAnimal(String name)
            return name;
        }
        public int getAnimalNumber() { //voor findAnimal(int animalNumber)
            return animalNumber;
        }
        @Override
        public int compareTo(Animal o) { //sortAnimals() volgens hun animalNumber.
            return this.animalNumber - o.animalNumber;
        }
        @Override
        public void vaccinateAnimal(Disease disease) {isVaccinated.replace(disease, true);}
        @Override
        public String toString() {
            return "ANIMAL" +
                    "ID:"   + String.format("%-5s", animalNumber) +
                    "Name:" + String.format("%-10s",name) +
                    "Age:"  + String.format("%-5s", age) +
                    "Disease:"  + isVaccinated + String.format("%-4s", "")+
                    "Clean:"+ String.format("%-5s", isClean)
            ;
        }
}
