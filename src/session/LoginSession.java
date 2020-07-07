package session;

/**
 * @author https://github.com/llawliet1945
 */
public class LoginSession {
    private static String ven;
    public static void setUserLogin(String id){
        ven=id;   
    }
    public static String getUserLogin(){
        return ven;
    }
}
