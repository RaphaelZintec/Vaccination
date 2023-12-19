package intecbrussel.be;

public class Cat extends Animal{
    //ATTRIBUTES
        private boolean hasLongNails;


    //CONSTRUCTORS
        public Cat(){}
        public Cat(boolean isClean, int age, String name, boolean hasLongNails) {
            super(isClean, age, name);
            this.hasLongNails = hasLongNails;
        }


    //METHODES
        @Override
        public void treatAnimal() {
            changeCleanStatus();
            hasLongNails = false;
        }
        @Override
        public String toString() {
            return super.toString().replaceAll("ANIMAL", "\uD83D\uDC31 CAT" + String.format("%-7s", "")) + "    LongNails:"+hasLongNails;
        }
}
