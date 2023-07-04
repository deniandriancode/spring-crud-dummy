package app;

public class Guest {

    public String name;
    public int age;
    public String occupation;

    public Guest(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return String.format("Guest { name: \"%s=\", age: %d, occupation: \"%s\" }", name, age, occupation);
    }

}
