package ca.bcit.comp2522.labs.collectionsLab;

import java.util.Objects;

public class NamedNumber implements Comparable<NamedNumber> {
    private int number;
    private String name;

    public NamedNumber(int aNumber, String aName) {
        number = aNumber;
        name = aName;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NamedNumber that = (NamedNumber) o;
        return number == that.number &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }

    //if this is smaller, return negative
    //if
    @Override
    public int compareTo(NamedNumber other) {
        return this.number - other.number;
    }
}
