
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author 
 *  @version 
 */
public class Reverse {
    public static Foo reverse(Foo foo) {

        if(foo.isEmpty()) {
            return foo;
        }
        
        return reverse(foo.cdr()).concat(foo.car());
        
        }
        
            
        }
    


