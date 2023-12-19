package intecbrussel.be;

public class Dog extends Animal{
    //ATTRIBUTES
        private boolean hasFoulBreath;


    //CONSTRUCTORS
        public Dog(){}
        public Dog(boolean isClean, int age, String name, boolean hasFoulBreath) {
            super(isClean, age, name);
            this.hasFoulBreath = hasFoulBreath;
        }

    //METHODES
        @Override
        public void treatAnimal() {
            changeCleanStatus();
            hasFoulBreath = false;
        }
        @Override
        public String toString() {
            return super.toString().replaceAll("ANIMAL", "\uD83D\uDC36 DOG" + String.format("%-7s", "")) + "    FoulBreath:"+hasFoulBreath;
        }
}
