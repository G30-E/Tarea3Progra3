package umg.edu.gt.stackhandler;

public class App {
    public static void main(String[] args) {
        SymbolValidator v = new SymbolValidator();

        String valid = "(a+b) * [c-d]";
        String invalid = "([)]";

        System.out.println(valid + " -> " + v.isValid(valid));
        System.out.println(invalid + " -> " + v.isValid(invalid));

        if (args.length > 0) {
            System.out.println(args[0] + " -> " + v.isValid(args[0]));
        }
    }
}




