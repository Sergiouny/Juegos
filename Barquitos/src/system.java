

class system {


    public static void print(Object txt){

        System.out.println(txt);
    }
    public static void print(Object txt, String end) {
        System.out.print(txt + end);
    }
    public static void print(Object txt, char sep) {
        System.out.print(txt + "" + sep);
    }
    public static void print(Object txt, char sep , String end) {
        System.out.print(txt + "" + sep + end);
    }

    public static void sep(){
        System.out.println("--------------------------------");
    }
}