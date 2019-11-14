/**
 * Foo is a sequence of items.
 * 
 * @author raf
 * @version 20191113
 */
public interface Foo {

    /**
     * getter indicating whether there are values or not.
     * 
     * @return true if there are values in this Foo
     */
    boolean isEmpty();


    /**
     * getter returning a new Foo object with the first value in the sequence
     * (this value is known as the head of the sequence). The method throws an
     * IndexOutOfBoundsException if the sequence is empty.
     * 
     * @return a new Foo object with the first value of the sequence
     */
    Foo car();


    /**
     * getter returning a new Foo object with the sequence in this Foo object
     * excluding its first value (all-values-but-the-first are known as the tail
     * of the sequence). If the sequence in the current Foo object is empty then
     * it returns a Foo object with an empty sequence.
     * 
     * @return a new Foo object with the rest of the sequence (excluding first)
     */
    Foo cdr();


    /**
     * method returning a new Foo object with the concatenation of the contents
     * of this Foo object and a.
     * 
     * @param a
     *            Foo object to be added to the end of this Foo
     * @return new Foo object that is the concatenation
     */
    Foo concat(Foo a);
}
