package intecbrussel.be;

public class Monkey extends Animal{
    //ATTRIBUTES
        private boolean isHyperActive;


    //CONSTRUCTORS
        public Monkey(){}
        public Monkey(boolean isClean, int age, String name, boolean isHyperActive) {
            super(isClean, age, name);
            this.isHyperActive = isHyperActive;
        }


    //METHODES
        @Override
        public void treatAnimal() {
            changeCleanStatus();
            isHyperActive = false;
        }
        @Override
        public String toString() {
            return super.toString().replaceAll("ANIMAL", "\uD83D\uDE48 MONKEY" + String.format("%-4s", "")) + "    Hyperactive:"+isHyperActive;
        }
}
