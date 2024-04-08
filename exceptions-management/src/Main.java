public class Main {
    public static void main(String[] args) throws Exception {

        //Debemos seguir el orden genealogico de excepciones, de las mas especificas a menos, siendo la menos especifica Throwable
        try {
            uncheckedTwoExceptions(false);
        } catch (RuntimeException e) {
            System.out.println("Runtime");
        } catch (Exception e) {
            System.out.println("Exception");
        } catch (Throwable e){
            System.out.println("Throwable");
        }

    }

    //Checked Exceptions
    private static void uncheckedTwoExceptions(boolean flag) throws Exception {
        if (flag) {
            throw new Exception();
        } else {
            throw new RuntimeException();
        }

    }

    //Checked Exceptions
    private static void checkedException() throws Exception {
        throw new Exception();
    }

    //Unchecked Exceptions
    private static void exampleArithmeticException() {
        double number = 10 / 0;
    }

    //Finally Example
    private static void finallyExample() throws Exception {
        try {
            checkedException();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception();
        } finally {
            System.out.println("Finally :)");
        }
    }

    //Many Catchs
    public static void manyCatchsExceptions() throws Exception {
        //Debemos seguir el orden genealogico de excepciones, de las mas especificas a menos, siendo la menos especifica Throwable
        try {
            checkedTwoExceptions(false);
        } catch (RuntimeException e) {
            System.out.println("Runtime");
        } catch (Exception e) {
            System.out.println("Exception");
        } catch (Throwable e){
            System.out.println("Throwable");
        }

    }

}